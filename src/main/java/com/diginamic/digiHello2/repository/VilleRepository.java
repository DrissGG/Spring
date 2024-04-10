package com.diginamic.digiHello2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginamic.digiHello2.model.Departement;
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

    /**
     * Recherche toutes les villes dont la population est comprise entre deux valeurs données.
     * @param minPopulation La population minimale.
     * @param maxPopulation La population maximale.
     * @return Une liste de villes dont la population est comprise entre les deux valeurs spécifiées.
     */
    List<Ville> findByPopulationBetween(int minPopulation, int maxPopulation);

    /**
     * Recherche toutes les villes d'un département dont la population est supérieure à une valeur minimale donnée.
     * @param codeDepartement Le code du département.
     * @param minPopulation La population minimale.
     * @return Une liste de villes du département dont la population est supérieure à la valeur spécifiée.
     */
    List<Ville> findByCodeDepartementAndPopulationGreaterThan(String codeDepartement, int minPopulation);

    /**
     * Recherche toutes les villes d'un département dont la population est comprise entre deux valeurs données.
     * @param codeDepartement Le code du département.
     * @param minPopulation La population minimale.
     * @param maxPopulation La population maximale.
     * @return Une liste de villes du département dont la population est comprise entre les deux valeurs spécifiées.
     */
    List<Ville> findByCodeDepartementAndPopulationBetween(String codeDepartement, int minPopulation, int maxPopulation);

    /**
     * Recherche les n villes les plus peuplées d'un département donné, classées par ordre décroissant de population.
     * @param codeDepartement Le code du département.
     * @param n Le nombre de villes à récupérer.
     * @return Les n villes les plus peuplées du département, classées par ordre décroissant de population.
     */
    List<Ville> findTopNByCodeDepartementOrderByPopulationDesc(String codeDepartement, int n);
    
    List<Ville> findByCodeDepartement(String codeDepartement);
    
}
