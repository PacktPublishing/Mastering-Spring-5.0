package com.mastering.spring.springboot.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeDataService {
    @Value("${somedataservice.url}")
    private String url;

    public String retrieveSomeData() {
        // Logic using the url and getting the data

        return "data from service";
    }
}
