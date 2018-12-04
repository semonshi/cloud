package com.didispace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.didispace.model.User;

@Component
public class ComputeClientHystrix implements ComputeClient {

	@Override
	public List<User> readUserInfo() {
		System.out.println("HystrixCommand fallbackMethod handle!");
        List<User> ls = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        user.setUsername("断路器回调方法测试");
        ls.add(user);
        return ls;
	}

}
