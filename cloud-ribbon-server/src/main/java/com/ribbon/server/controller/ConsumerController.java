package com.ribbon.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ribbon.server.model.User;

@RefreshScope
@RestController
public class ConsumerController {
	

    final String SERVICE_NAME = "cloud-simple-service";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/user")
    public List<User> readUserInfo() {
        return restTemplate.getForObject("http://" + SERVICE_NAME + "/user", List.class);
    }
    

}