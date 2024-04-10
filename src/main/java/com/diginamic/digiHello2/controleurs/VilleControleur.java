package com.diginamic.digiHello2.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.digiHello2.model.Ville;
import com.diginamic.digiHello2.repository.VilleRepository;
import com.diginamic.digiHello2.service.VilleService;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

	@Autowired
	private VilleService villeService;
	@Autowired
    private VilleRepository villeRepository;
	
	@GetMapping("/villes")
	public List<Ville> getVilles() {			
		//return villeService.extractVilles();		
		return villeRepository.findAll();
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
	 
	 @GetMapping("/nom/{nom}")
	 public List<Ville> getVillesByNom(@PathVariable String nom) {
		 return villeRepository.findByNomStartingWith(nom);
	 }
	 
	 @GetMapping("/population/{min}")
	 public List<Ville> getVillesByPopulationGreaterThan(@PathVariable int min) {
		 return villeRepository.findByPopulationGreaterThan(min);
	 }
	 
	 @GetMapping("/population/{min}/{max}")
	    public List<Ville> getVillesByPopulationRange(@PathVariable int min, @PathVariable int max) {
	        return villeRepository.findByPopulationBetween(min, max);
	    }

	    @GetMapping("/departement/{codeDepartement}")
	    public List<Ville> getVillesByDepartement(@PathVariable String codeDepartement) {
	        return villeRepository.findByCodeDepartement(codeDepartement);
	    }

	    @GetMapping("/departement/{codeDepartement}/population/{min}")
	    public List<Ville> getVillesByDepartementAndMinPopulation(@PathVariable String codeDepartement, @PathVariable int minPopulation) {
	        return villeRepository.findByCodeDepartementAndPopulationGreaterThan(codeDepartement, minPopulation);
	    }

	    @GetMapping("/departement/{codeDepartement}/population/{min}/{max}")
	    public List<Ville> getVillesByDepartementAndPopulationRange(@PathVariable String codeDepartement, @PathVariable int min, @PathVariable int max) {
	        return villeRepository.findByCodeDepartementAndPopulationBetween(codeDepartement, min, max);
	    }

	    @GetMapping("/departement/{codeDepartement}/top/{n}")
	    public List<Ville> getTopNVillesByDepartement(@PathVariable String codeDepartement, @PathVariable int n) {
	        return villeRepository.findTopNByCodeDepartementOrderByPopulationDesc(codeDepartement, n);
	    }
	    
}
