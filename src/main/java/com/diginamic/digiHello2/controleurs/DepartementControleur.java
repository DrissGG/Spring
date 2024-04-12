package com.diginamic.digiHello2.controleurs;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.digiHello2.dto.DepartementDto;
import com.diginamic.digiHello2.model.Departement;
import com.diginamic.digiHello2.service.DepartementService;

@RestController
@RequestMapping("/departements")
public class DepartementControleur {

    @Autowired
    private DepartementService departementService;

    // Méthode pour récupérer la liste des départements
    @GetMapping
    public ResponseEntity<List<DepartementDto>> getDepartements(){
        List<DepartementDto> departements = departementService.extractDepartements();
        return ResponseEntity.ok(departements);
    }

    // Méthode pour récupérer un département par son ID
    @GetMapping("/{id}")
    public ResponseEntity<DepartementDto> getDepartementById(@PathVariable Long id) {
        DepartementDto departement = departementService.extractDepartement(id);
        if (departement != null) {
            return ResponseEntity.ok(departement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Méthode pour créer un nouveau département
    @PostMapping
    public ResponseEntity<String> createDepartement(@RequestBody DepartementDto departementDto) {
        Departement departement = departementService.insertDepartement(departementDto);
        if (departement != null) {
            return ResponseEntity.ok("Département créé avec succès.");
        } else {
            return ResponseEntity.badRequest().body("Erreur de création du département.");
        }
    }

    // Méthode pour mettre à jour un département existant
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartement(@PathVariable Long id, @RequestBody DepartementDto departementDto) {
        Departement updatedDepartement = departementService.modifyDepartement(id, departementDto);
        if (updatedDepartement != null) {
            return ResponseEntity.ok("Département mis à jour avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Méthode pour supprimer un département par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartement(@PathVariable Long id) {
        boolean deleted = departementService.deleteDepartement(id);
        if (deleted) {
            return ResponseEntity.ok("Département supprimé avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportToCsv() {
        try {
            List<DepartementDto> departements = departementService.extractDepartements();
            byte[] csvData = departementService.exportToCsv(departements);

            // Retourne le fichier CSV en tant que réponse avec un code de statut OK
            return ResponseEntity
                    .ok()
                    .header("Content-Disposition", "attachment; filename=departements.csv")
                    .body(csvData);
        } catch (IOException e) {
            // En cas d'erreur lors de la génération du fichier CSV, retourne une réponse avec un code d'erreur interne du serveur
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}