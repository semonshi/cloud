package com.didispace.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.didispace.model.User;

@FeignClient(value="cloud-simple-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {
	
    @RequestMapping(value = "/user")
    List<User> readUserInfo();

}