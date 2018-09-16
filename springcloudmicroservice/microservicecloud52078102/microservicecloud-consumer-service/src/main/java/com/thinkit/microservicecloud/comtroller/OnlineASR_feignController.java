package com.thinkit.microservicecloud.comtroller;

import com.thinkit.microservicecloud.entities.onlineasr.PointCut;
import com.thinkit.microservicecloud.entities.onlineasr.RealtimeAsrReq;
import com.thinkit.microservicecloud.entities.onlineasr.VoiceRec;
import com.thinkit.microservicecloud.entities.userlogin.ResultInfo;
import com.thinkit.microservicecloud.entities.voiceprint.VoiceResult;
import com.thinkit.microservicecloud.service.IOnlineAsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class OnlineASR_feignController {


    @Autowired
    private IOnlineAsrService service;

    @RequestMapping(value = "/consumer/onlineasr/rec", method = RequestMethod.POST)
    public VoiceResult rec(@RequestBody VoiceRec vrec) {
        return service.rec(vrec);
    }

    @RequestMapping(value = "/consumer/onlineasr/recording", method = RequestMethod.POST)
    public Map<String,Object> recording(@RequestBody PointCut info) throws  Exception{
      return   service.recording(info);
    }

    @RequestMapping(value="/consumer/service/realtimeasr",method= RequestMethod.POST )
    public ResultInfo realtimeAsr(@RequestBody RealtimeAsrReq info) {
        return service.realtimeAsr(info);
    }
}
