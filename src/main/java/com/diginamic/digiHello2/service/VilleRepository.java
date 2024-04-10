package com.diginamic.digiHello2.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.digiHello2.model.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {
    Ville findByNom(String nom);
}
