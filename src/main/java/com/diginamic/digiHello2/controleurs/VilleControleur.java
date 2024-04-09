package com.diginamic.digiHello2.controleurs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.digiHello2.model.Ville;

@RestController
public class VilleControleur {
	
	@GetMapping("/villes")
	public List<Ville> getVilles() {
		
		List<Ville> listVilles = new ArrayList<>();
		listVilles.add(new Ville("Paris", 30000));
		listVilles.add(new Ville("Lyon", 79000));
		listVilles.add(new Ville("Montpellier", 63000));
		
		return listVilles;
		
	}
}
