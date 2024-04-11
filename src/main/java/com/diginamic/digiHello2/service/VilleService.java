package com.diginamic.digiHello2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.digiHello2.mapper.DepartementMapper;
import com.diginamic.digiHello2.model.Departement;
import com.diginamic.digiHello2.model.Ville;
import com.diginamic.digiHello2.repository.VilleRepository;

import jakarta.transaction.Transactional;

@Service
public class VilleService {
	@Autowired
    private VilleRepository villeRepository;
	
	@Autowired
	private DepartementService depService;

	
	public List<Ville> extractVilles(){
		return villeRepository.findAll();
	}
	public Ville extractVille(int idVille) {
		return villeRepository.findById(idVille).orElse(null);
	}
	public Ville extractVille(String nom) {
		return villeRepository.findByNom(nom);
	}
	public List<Ville> insertVille(Ville ville){
		villeRepository.save(ville);
		return extractVilles();
	}
	public List<Ville> modifierVille(int idVille, Ville villeModifiee) {
		 Ville v = villeRepository.findById(idVille).orElse(null);
		 if(v != null) {
			 v.setNom(villeModifiee.getNom());
			 v.setPopulation(villeModifiee.getPopulation());
			 v.setDepartement(villeModifiee.getDepartement());
			 villeRepository.save(v);
		 }
		 return extractVilles();
	 }
	public List<Ville> supprimerVille(int idVille){
		villeRepository.deleteById(idVille);
		return extractVilles();
	}
	
	@Transactional
	public void init() {
	    // Ajout de 10 départements
	    Departement d1 = new Departement("34", "Herault");
	    Departement d2 = new Departement("31", "Haute-Garonne");
	    Departement d3 = new Departement("75", "Paris");
	    Departement d4 = new Departement("69", "Rhone");
	    Departement d5 = new Departement("13", "Bouches-du-Rhone");
	    Departement d6 = new Departement("44", "Loire-Atlantique");
	    Departement d7 = new Departement("29", "Finistere");
	    Departement d8 = new Departement("06", "Alpes-Maritimes");
	    Departement d9 = new Departement("59", "Nord");
	    Departement d10 = new Departement("83", "Var");

//	    // Sauvegarde des départements
//	    depService.insertDepartement(DepartementMapper.toDto(d1));
//	    depService.insertDepartement(DepartementMapper.toDto(d2));
//	    depService.insertDepartement(DepartementMapper.toDto(d3));
//	    depService.insertDepartement(DepartementMapper.toDto(d4));
//	    depService.insertDepartement(DepartementMapper.toDto(d5));
//	    depService.insertDepartement(DepartementMapper.toDto(d6));
//	    depService.insertDepartement(DepartementMapper.toDto(d7));
//	    depService.insertDepartement(DepartementMapper.toDto(d8));
//	    depService.insertDepartement(DepartementMapper.toDto(d9));
//	    depService.insertDepartement(DepartementMapper.toDto(d10));


	    // Ajout de 20 villes
	    Ville v1 = new Ville("Montpellier", 13333, d1);
	    Ville v2 = new Ville("Toulouse", 24444, d2);
	    Ville v3 = new Ville("Paris", 8999, d3);
	    Ville v4 = new Ville("Lyon", 15555, d4);
	    Ville v5 = new Ville("Marseille", 20000, d5);
	    Ville v6 = new Ville("Nantes", 18000, d6);
	    Ville v7 = new Ville("Brest", 12000, d7);
	    Ville v8 = new Ville("Nice", 25000, d8);
	    Ville v9 = new Ville("Lille", 16000, d9);
	    Ville v10 = new Ville("Toulon", 21000, d10);
	    Ville v11 = new Ville("Perpignan", 15000, d1);
	    Ville v12 = new Ville("Bordeaux", 22000, d2);
	    Ville v13 = new Ville("Strasbourg", 17000, d3);
	    Ville v14 = new Ville("Rennes", 13000, d4);
	    Ville v15 = new Ville("Reims", 14000, d5);
	    Ville v16 = new Ville("Le Havre", 11000, d6);
	    Ville v17 = new Ville("Saint-Etienne", 9000, d7);
	    Ville v18 = new Ville("Toulon", 22000, d8);
	    Ville v19 = new Ville("Grenoble", 20000, d9);
	    Ville v20 = new Ville("Dijon", 18000, d10);

	    // Sauvegarde des villes
	    villeRepository.save(v1);
	    villeRepository.save(v2);
	    villeRepository.save(v3);
	    villeRepository.save(v4);
	    villeRepository.save(v5);
	    villeRepository.save(v6);
	    villeRepository.save(v7);
	    villeRepository.save(v8);
	    villeRepository.save(v9);
	    villeRepository.save(v10);
	    villeRepository.save(v11);
	    villeRepository.save(v12);
	    villeRepository.save(v13);
	    villeRepository.save(v14);
	    villeRepository.save(v15);
	    villeRepository.save(v16);
	    villeRepository.save(v17);
	    villeRepository.save(v18);
	    villeRepository.save(v19);
	    villeRepository.save(v20);
	}


}
