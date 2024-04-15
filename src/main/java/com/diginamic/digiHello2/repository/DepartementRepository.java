package com.diginamic.digiHello2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diginamic.digiHello2.model.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
	 Departement findByCode(String code); 
}
