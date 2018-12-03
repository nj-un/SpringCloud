package com.gx.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "feign-hello")
public interface HelloClient {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/hello")
    String findStudentByName(@RequestParam("name") String name);
}
