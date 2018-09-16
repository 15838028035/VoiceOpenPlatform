package com.thinkit.microservicecloud.controller;

import com.thinkit.microservicecloud.entities.console.MyApps;
import com.thinkit.microservicecloud.entities.console.UserApp;
import com.thinkit.microservicecloud.service.IConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAppController {

    @Autowired
    private IConsoleService service;

    @RequestMapping(value = "/consumer/console/myapps/{session}",method = RequestMethod.GET)
    public List<MyApps> myapps(@PathVariable("session") String session){

      return   service.myapps(session);
    }


    @RequestMapping(value = "/consumer/console/createapp/{session}",method = RequestMethod.POST)
    public String createUserApp(@RequestBody UserApp info, @PathVariable String session){
        return  service.createUserApp(info,session);
    }
}
