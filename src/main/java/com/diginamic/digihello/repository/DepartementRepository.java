package com.diginamic.digihello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diginamic.digihello.model.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
	 Departement findByCode(String code); 
}
