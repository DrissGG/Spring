package com.diginamic.digihello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diginamic.digihello.config.Config;

@SpringBootApplication
public class DigiHello2Application {
	@Autowired
	private Config conf;
	
	public static void main(String[] args) {
		SpringApplication.run(DigiHello2Application.class, args);		
		
	}

	

}
