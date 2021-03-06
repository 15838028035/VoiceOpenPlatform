package com.thinkit.microservicecloud.controller;

import com.thinkit.microservicecloud.entities.console.ServiceProduct;
import com.thinkit.microservicecloud.service.IConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceProductController {

    @Autowired
    private IConsoleService service;

    @RequestMapping(value="/consumer/console/serviceproduct/selectProducts/{session}",method = RequestMethod.GET)
    public List<ServiceProduct> selectProducts(@PathVariable("session") String session){

        return  service.selectProducts(session);
    }
}
