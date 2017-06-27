package com.mastering.spring.springboot.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastering.spring.springboot.configuration.ApplicationConfiguration;

@Component
public class SomeOtherDataService {
    @Autowired
    private ApplicationConfiguration configuration;

    public String retrieveSomeData() {
        // Logic using the url and getting the data
        System.out.println(configuration.getService1Timeout());
        System.out.println(configuration.getService1Url());
        System.out.println(configuration.isEnableSwitchForService1());

        return "data from service";
    }
}
