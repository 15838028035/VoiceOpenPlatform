package com.thinkit.microservicecloud.service.impl;

import com.thinkit.microservicecloud.dao.UserCurd;
import com.thinkit.microservicecloud.entities.userlogin.PhonePassword;
import com.thinkit.microservicecloud.entities.userlogin.User;
import com.thinkit.microservicecloud.entities.userlogin.UserLogin;
import com.thinkit.microservicecloud.entities.userlogin.UserRegister;
import com.thinkit.microservicecloud.service.UserCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCurdServiceImpl implements UserCurdService {

    @Autowired
    private UserCurd dao;
    @Override
    public void insert(UserRegister info) {
         dao.insert(info);
    }

    @Override
    public List<User> userLogin(UserLogin userLogin) {
        return dao.userLogin(userLogin);
    }

    @Override
    public void resetPassword(PhonePassword info) {
        dao.resetPassword(info);
    }
}
