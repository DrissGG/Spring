package com.diginamic.digiHello2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<GrantedAuthority> authorities = new ArrayList<>();
		
	public UserAccount(Long id, String username, String password, String... authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = Arrays.stream(authorities)
				.map(SimpleGrantedAuthority::new)
				.map(GrantedAuthority.class::cast)
				.toList() ;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	
}
