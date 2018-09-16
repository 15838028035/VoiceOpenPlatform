package com.thinkit.microservicecloud.service;

import com.thinkit.microservicecloud.entities.console.MyApps;
import com.thinkit.microservicecloud.entities.console.ServiceProduct;
import com.thinkit.microservicecloud.entities.console.UserApp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-CONSOLE")
public interface IConsoleService {

    @RequestMapping(value = "/privoder/console/createapp/{session}",method = RequestMethod.POST)
    public String createUserApp(@RequestBody UserApp info, @PathVariable("session") String session);


    @RequestMapping(value = "/privoder/console/myapps/{session}",method = RequestMethod.GET)
    public List<MyApps> myapps(@PathVariable("session") String session);


    @RequestMapping(value="/privoder/console/serviceproduct/selectProducts/{session}",method = RequestMethod.GET)
    public List<ServiceProduct> selectProducts(@PathVariable("session") String session);
}
