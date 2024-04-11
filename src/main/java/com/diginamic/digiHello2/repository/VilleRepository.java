package com.diginamic.digiHello2.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.digiHello2.model.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {
    Ville findByNom(String nom);
    
    /**
     * Recherche toutes les villes dont le nom commence par une chaîne de caractères donnée.
     * @param nom Le nom à rechercher.
     * @return Une liste de villes dont le nom commence par la chaîne spécifiée.
     */
    List<Ville> findByNomStartingWith(String nom);

    /**
     * Recherche toutes les villes dont la population est supérieure à une valeur minimale donnée.
     * @param minPopulation La population minimale.
     * @return Une liste de villes dont la population est supérieure à la valeur spécifiée.
     */
    List<Ville> findByPopulationGreaterThan(int minPopulation);

 

    List<Ville> findByDepartement_Code(String code); // Uses the 'code' of the Departement entity

    List<Ville> findByPopulationBetween(int minPopulation, int maxPopulation);

    Page<Ville> findNByDepartement_CodeOrderByPopulationDesc(String code, Pageable pageable);
    
}
