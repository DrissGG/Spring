package com.diginamic.digiHello2.controleurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.digiHello2.model.Ville;

@RestController
public class VilleControleur {
	
	List<Ville> listVilles = new ArrayList<>(Arrays.asList(new Ville("Paris", 30000),new Ville("Lyon", 79000),new Ville("Montpellier", 63000)));
	
	@GetMapping("/villes")
	public List<Ville> getVilles() {		
		
		
		return listVilles;
		
	}
	
	@PostMapping("/villes")
	public ResponseEntity<String> insertVille(@RequestBody Ville nvVille){
		for(Ville v : listVilles) {
			if(v.getNom().equals(nvVille.getNom())) {
				return ResponseEntity.badRequest().body("La ville existe déja");
			}
			
		}
		listVilles.add(nvVille);
		return ResponseEntity.ok("La ville a été insére !");
		
	}

}
