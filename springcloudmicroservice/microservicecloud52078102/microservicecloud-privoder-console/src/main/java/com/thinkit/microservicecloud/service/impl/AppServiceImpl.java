package com.thinkit.microservicecloud.service.impl;

import com.thinkit.microservicecloud.dao.AppCurd;
import com.thinkit.microservicecloud.entities.console.MyApps;
import com.thinkit.microservicecloud.entities.console.UserApp;
import com.thinkit.microservicecloud.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppCurd service;

    @Override
    public void createApp(UserApp info) {
        service.createApp(info);
    }


    public List<MyApps> myapps(int userid){
        return service.myapps(userid);
    }
}
