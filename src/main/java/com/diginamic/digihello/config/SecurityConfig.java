package com.diginamic.digihello.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.diginamic.digihello.repository.UserAccountRepository;
import com.diginamic.digihello.repository.VilleRepository;

@Configuration

public class SecurityConfig {
	@Autowired
	VilleRepository villeRepository;
	@Bean
	UserDetailsService userDetailsService(UserAccountRepository userAccountRepository)
	{
		return username -> userAccountRepository.findByUsername(username).asUser();
	}

	@Bean
	SecurityFilterChain configureSecurity(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(request -> request
		.requestMatchers("login").permitAll() //permet l'accès au login a tous
		.requestMatchers("/", "/index").authenticated()
		.requestMatchers(HttpMethod.GET, "/villes/**").authenticated()		
		.requestMatchers(HttpMethod.POST, "/villes/**").hasRole("ADMIN")
		.requestMatchers("/supprimerVille").hasRole("ADMIN") // Autorise seulement les utilisateurs avec le rôle ADMIN à accéder à cet endpoint
        .requestMatchers("/admin").hasRole("ADMIN")
		.anyRequest().denyAll() //tout le reste est sécurise 
		)
		.httpBasic(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults());
		return http.build();			
	}
	

	
}
