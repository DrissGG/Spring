package com.diginamic.digihello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.diginamic.digihello.model.Ville;
import com.diginamic.digihello.repository.UserAccountRepository;
import com.diginamic.digihello.repository.VilleRepository;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	@Autowired
	VilleRepository villeRepository;
	@Bean
	UserDetailsService userDetailsService(UserAccountRepository userAccountRepository)
	{
		return username -> userAccountRepository.findByUsername(username).asUser();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//		userDetailsManager.createUser(
//				User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("user")
//				.roles("USER")
//				.build());
//		userDetailsManager.createUser(
//				User.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("admin")
//				.roles("ADMIN")
//				.build());
//		
//		return userDetailsManager;
//	}
	
	@Bean
	SecurityFilterChain configureSecurity(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.requestMatchers("login").permitAll() //permet l'accès au login a tous
		.requestMatchers("/", "/index", "/deleteVilles").authenticated()
		.requestMatchers("/admin").hasRole("ADMIN")
		.requestMatchers("/", "/index").authenticated()
		.requestMatchers(HttpMethod.GET, "/villes/**").authenticated()
		.requestMatchers("/admin").hasRole("ADMIN")
		.requestMatchers(HttpMethod.POST, "/villes/**").hasRole("ADMIN")
		.anyRequest().denyAll() //tout le reste est sécurise 
		.and()
		.formLogin()
		.and()
		.httpBasic();
		return http.build();	
		
	}
	

	
}
