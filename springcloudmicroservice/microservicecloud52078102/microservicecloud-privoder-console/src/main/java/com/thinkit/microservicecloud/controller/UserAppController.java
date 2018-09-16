package com.thinkit.microservicecloud.controller;

import com.thinkit.microservicecloud.entities.console.AppService;
import com.thinkit.microservicecloud.entities.console.MyApps;
import com.thinkit.microservicecloud.entities.console.ServiceProduct;
import com.thinkit.microservicecloud.entities.console.UserApp;
import com.thinkit.microservicecloud.service.impl.AppServiceImpl;
import com.thinkit.microservicecloud.service.impl.ProductServiceImpl;
import com.thinkit.microservicecloud.service.impl.ServiceServiceImpl;
import com.thinkit.microservicecloud.util.GenerateAppId;
import com.thinkit.microservicecloud.util.GenerateSessionId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class UserAppController {

    private Logger logger  = LoggerFactory.getLogger(UserAppController.class);

    @Autowired
    private AppServiceImpl service;

    @Autowired
    private ServiceServiceImpl serviceService;

    @Autowired
    private ProductServiceImpl pservice;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping(value = "/privoder/console/createapp/{session}",method = RequestMethod.POST)
    public String createUserApp(@RequestBody UserApp info, @PathVariable String session){
        logger.info("this input parameter is " +info.toString());

        logger.info("controller: session- "+session);
        selectDb(1);
        String userid =  getValue(session);
        logger.info("session 对应的 userid is :"+ userid );

        String appid  = GenerateAppId.getAppId();
        info.setAppid(appid);
        info.setAppkey(appid);
        info.setUserid(Integer.parseInt(userid));


        service.createApp(info);

        int id = info.getId();
        // 插入服务数据表

        for(int i : info.getServiceids()){

            logger.info("get Servcieids: "+ i);
            ServiceProduct product =  pservice.selectById(i);
            AppService as = new AppService();
            as.setAppid(id);
            as.setProductid(i);
            as.setIndate(product.getDefault_day());
            as.setQps(product.getDefault_qps());
            as.setState("限时免费");
            String skey = "token_"+GenerateSessionId.getSid();
            as.setSecret_key(skey);

            serviceService.createService(as);
            selectDb(2);
            setkeyEffective(skey,as.getServiceid()+"");


        }

        return "this parameter is " +info.toString();
    }



    public  String  getValue(String key){

        return redisTemplate.opsForValue().get(key);

    }


    // key-value  token_sid -- serviceid  3 天
    public void setkeyEffective(String key,String value){

        redisTemplate.opsForValue().set(key,value,3 ,TimeUnit.DAYS);
    }



    @RequestMapping(value = "/privoder/console/myapps/{session}",method = RequestMethod.GET)
    public List<MyApps> myapps(@PathVariable("session") String session){

        selectDb(1);
        int userid =   Integer.parseInt(getValue(session));
        return   service.myapps(userid);
    }


    public void selectDb(int dbindex){

        JedisConnectionFactory jedisConnectionFactory  = ( JedisConnectionFactory )  redisTemplate.getConnectionFactory();
        jedisConnectionFactory.setDatabase(dbindex);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
    }
}
