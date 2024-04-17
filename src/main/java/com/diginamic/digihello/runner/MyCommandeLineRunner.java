package com.diginamic.digihello.runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.diginamic.digihello.DigiHello2Application;
import com.diginamic.digihello.dto.DepartementDto;
import com.diginamic.digihello.dto.VilleDto;
import com.diginamic.digihello.exception.VilleExistsException;
import com.diginamic.digihello.mapper.VilleMapper;
import com.diginamic.digihello.model.UserAccount;
import com.diginamic.digihello.model.Ville;
import com.diginamic.digihello.repository.UserAccountRepository;
import com.diginamic.digihello.service.DepartementService;
import com.diginamic.digihello.service.VilleService;

@Component
public class MyCommandeLineRunner implements CommandLineRunner{
	
	 	@Autowired
	    private DepartementService departementService;

	    @Autowired
	    private VilleService villeService;
	    @Autowired
	    private UserAccountRepository userAccountRepository;
	    
	public static void main(String[] args) {
//		SpringApplication.run(DigiHello2Application.class, args);
		SpringApplication sa = new SpringApplication(DigiHello2Application.class);
		sa.setWebApplicationType(WebApplicationType.NONE);
		sa.run(args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
//		UserAccount userAccount = new UserAccount("naruto", "naruto", "USER");
//		UserAccount userAccount2 = new UserAccount("sisi", "sisi", "USER");
//		UserAccount userAccount3 = new UserAccount("luffy", "luffy", "ADMIN");
//		
//		userAccountRepository.save(userAccount);
//		userAccountRepository.save(userAccount2);
//		userAccountRepository.save(userAccount3);
		
		System.out.println("OK");
		
	}
	

}
