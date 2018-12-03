package com.gx.feignhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignHelloApplication.class, args);
    }
}
