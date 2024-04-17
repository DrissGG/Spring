package com.diginamic.digihello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diginamic.digihello.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	public UserAccount findByUsername(String username);

}
