package com.thinkit.microservicecloud.service;

import com.thinkit.microservicecloud.entities.console.MyApps;
import com.thinkit.microservicecloud.entities.console.UserApp;

import java.util.List;

public interface AppService {
    public void createApp(UserApp info);

    public List<MyApps> myapps(int userid);
}
