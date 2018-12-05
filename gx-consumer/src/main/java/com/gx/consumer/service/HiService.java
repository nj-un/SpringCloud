package com.gx.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HiService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "ribbonFallback")
    public String hello() {
        return restTemplate.getForObject("http://gx-provider/hello", String.class);
    }

    public String ribbonFallback() {
        return "My Name's ribbonFallback";
    }
}
