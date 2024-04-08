package com.diginamic.digiHello2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diginamic.digiHello2.config.Config;

@SpringBootApplication
public class DigiHello2Application {
	@Autowired
	private Config conf;
	
	public static void main(String[] args) {
		SpringApplication.run(DigiHello2Application.class, args);
		
	}

}
