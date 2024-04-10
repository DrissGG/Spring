package com.diginamic.digiHello2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.digiHello2.model.Departement;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    // Méthode pour extraire tous les départements
    public List<Departement> extractDepartements() {
        return departementRepository.findAll();
    }

    // Méthode pour extraire un département par son ID
    public Departement extractDepartement(Long id) {
        return departementRepository.findById(id).orElse(null);
    }

    // Méthode pour insérer un nouveau département
    public Departement insertDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    // Méthode pour modifier un département existant
    public Departement modifyDepartement(Long id, Departement newDepartement) {
        Departement existingDepartement = departementRepository.findById(id).orElse(null);
        if (existingDepartement != null) {
            // Modifier les attributs du département existant avec les valeurs du nouveau département
            existingDepartement.setNom(newDepartement.getNom());
            // Vous pouvez ajouter d'autres attributs ici selon votre modèle de données
            return departementRepository.save(existingDepartement);
        }
        return null;
    }

    // Méthode pour supprimer un département par son ID
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }
}
