package com.diginamic.digiHello2.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.digiHello2.dto.VilleDto;
import com.diginamic.digiHello2.exception.VilleExistsException;
import com.diginamic.digiHello2.mapper.VilleMapper;
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

	@GetMapping("/")
	public List<Ville> getVilles() {
		// return villeService.extractVilles();
		return villeRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ville> getVilleId(@PathVariable int id) {
		Ville v = villeService.extractVille(id);
		if (v != null) {
			return ResponseEntity.ok(v);
		} else {
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

	@GetMapping("/departement/{departementCode}")
	public List<Ville> getVillesByDepartement(@PathVariable String departementCode) {
		return villeRepository.findByDepartement_Code(departementCode);
	}

	@GetMapping("/departement/{departementCode}/population/{min}/{max}")
	public List<Ville> getVillesByDepartementAndPopulationRange(@PathVariable String departementCode,
			@PathVariable int min, @PathVariable int max) {
		Page<Ville> page = villeRepository.findNByDepartement_CodeOrderByPopulationDesc(departementCode,
				Pageable.ofSize(max - min + 1));
		return page.getContent();
	}

	@PostMapping("/init")
	public ResponseEntity<String> initializeData() {
		villeService.init();
		return ResponseEntity.ok("Data initialized successfully");
	}
	@PostMapping("")
	public ResponseEntity<Ville> insertVille(@RequestBody VilleDto vdto) throws VilleExistsException {
		Ville v = VilleMapper.toBean(vdto);
		Ville ville = villeService.insertVille(v);
		return ResponseEntity.ok(ville);
		
	}
}
