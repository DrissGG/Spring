package com.diginamic.digihello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.digihello.config.Config;

@Service
public class UserService {
	private Config conf;
	
//	public UserService(Config conf) {
//		this.conf = conf;
//		System.out.println("userService constructor "+conf.toString());
//	}
	@Autowired
	public void setConfig(Config conf) {
		this.conf = conf;
		System.out.println("userService setter "+conf.toString());
	}
}
