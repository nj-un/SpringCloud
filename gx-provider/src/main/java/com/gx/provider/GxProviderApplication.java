package com.gx.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GxProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GxProviderApplication.class, args);
    }
}
