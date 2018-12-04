package com.didispace.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.model.User;
import com.didispace.service.ComputeClient;

@RestController
public class ConsumerController {

    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/queryuser")
    public List<User> readUserInfo() {
    	return computeClient.readUserInfo();
    }

}