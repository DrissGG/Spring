package com.diginamic.digihello.controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.digihello.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloControleur {
	
	@Autowired
	private HelloService helloservice;
	
	@GetMapping
	public String direHello() {
		return helloservice.salutations();
	}
}
