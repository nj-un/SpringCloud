package com.gx.ribbon.controller;

import com.gx.config.FooConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name = "consul-client", configuration = FooConfiguration.class)
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbon")
    public String findHelloByEmail(String email) {
        // VIP模式，不需要填写 IP+端口 Ribbon会去注册中心获取当前可用服务然后做HTTP请求
        return "server  <<==>>  " + restTemplate.getForObject("http://consul-client/hello?email=" + email, String.class);
    }
}
