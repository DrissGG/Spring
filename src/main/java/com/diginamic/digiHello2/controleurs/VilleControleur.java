package com.diginamic.digiHello2.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.digiHello2.model.Ville;
import com.diginamic.digiHello2.service.VilleService;

@RestController
public class VilleControleur {

	@Autowired
	private VilleService villeService;

	
	@GetMapping("/villes")
	public List<Ville> getVilles() {			
		return villeService.extractVilles();		
	}
	
	@GetMapping("/villes/{id}")
	public ResponseEntity<Ville> getVilleId(@PathVariable int id) {		
		Ville v = villeService.extractVille(id);
		if(v != null) {
			return ResponseEntity.ok(v);
		}else {				
			return ResponseEntity.notFound().build();
		}
	}
	 @PostMapping("/villes")
	    public ResponseEntity<String> insertVille(@RequestBody Ville nvVille) {
	        Ville villeExistante = villeService.extractVille(nvVille.getNom());
	        if (villeExistante != null) {
	            return ResponseEntity.badRequest().body("La ville existe déjà");
	        } else {
	            villeService.insertVille(nvVille);
	            return ResponseEntity.ok("La ville a été insérée !");
	        }
	    }

	    @PutMapping("/villes/{id}")
	    public ResponseEntity<String> updateVille(@PathVariable int id, @RequestBody Ville villeModifiee) {
	        Ville ville = villeService.extractVille(id);
	        if (ville != null) {
	            villeService.modifierVille(id, villeModifiee);
	            return ResponseEntity.ok("La ville a été modifiée !");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/villes/{id}")
	    public ResponseEntity<String> deleteVille(@PathVariable int id) {
	        Ville ville = villeService.extractVille(id);
	        if (ville != null) {
	            villeService.supprimerVille(id);
	            return ResponseEntity.ok("La ville a été supprimée !");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
