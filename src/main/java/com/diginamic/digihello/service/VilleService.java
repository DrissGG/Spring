package com.diginamic.digihello.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.diginamic.digihello.exception.VilleExistsException;
import com.diginamic.digihello.model.Departement;
import com.diginamic.digihello.model.Ville;
import com.diginamic.digihello.repository.DepartementRepository;
import com.diginamic.digihello.repository.VilleRepository;

import jakarta.transaction.Transactional;


@Service
public class VilleService {
	
	@Autowired
    private VilleRepository villeRepository;
	
	@Autowired
	private DepartementService depService;
	
	@Autowired
	private DepartementRepository departementRepository;
	
	
	public List<Ville> extractVilles(){
		return villeRepository.findAll();
	}
	public Ville extractVille(int idVille) {
		return villeRepository.findById(idVille).orElse(null);
	}
	public Ville extractVille(String nom) {
		return villeRepository.findByNom(nom);
	}
	public Ville insertVille(Ville ville) throws VilleExistsException{
		
		 // La ville doit avoir au moins 10 habitants
		 if(ville.getPopulation() < 10) {
			 throw new VilleExistsException("La ville doit avoir au moins 10 habitants.");
		 }
		 
		// Vérifier si le nom de la ville contient au moins 2 lettres
		 if (ville.getNom().length() < 2) {
			 throw new VilleExistsException("Le nom de la ville doit contenir au moins 2 lettres.");
	     }
		 //Le code département doit obligatoire 2 caractères
		 if(ville.getDepartement().getCode().length() !=2){
			 throw new VilleExistsException("Le code département doit obligatoire avoir 2 caractères");
	     }	
		 if (villeRepository.findByNomAndDepartementCode(ville.getNom(), ville.getDepartement().getCode()) != null) {
	            throw new VilleExistsException("La ville existe déjà pour ce département.");
	      }
		 Departement d  = departementRepository.findByCode(ville.getDepartement().getCode());
		 if(d !=null) {
			 ville.setDepartement(d);
		 }
		villeRepository.save(ville);
		return ville;
	}
	
	public Ville modifierVille(int idVille, Ville villeModifiee) throws VilleExistsException {
		 Ville v = villeRepository.findById(idVille).orElse(null);
		 if(v != null) {
			  // La ville doit avoir au moins 10 habitants
		        if (villeModifiee.getPopulation() < 10) {
		            throw new VilleExistsException("La ville doit avoir au moins 10 habitants.");
		        }

		        // Vérifier si le nom de la ville contient au moins 2 lettres
		        if (villeModifiee.getNom().length() < 2) {
		            throw new VilleExistsException("Le nom de la ville doit contenir au moins 2 lettres.");
		        }

		        // Le code département doit obligatoirement avoir 2 caractères
		        if (villeModifiee.getDepartement().getCode().length() != 2) {
		            throw new VilleExistsException("Le code département doit obligatoirement avoir 2 caractères");
		        }

		        // Vérifier si le nom de la ville est unique pour le département
		        Ville existingVilleWithSameName = villeRepository.findByNomAndDepartementCode(villeModifiee.getNom(), villeModifiee.getDepartement().getCode());
		        if (existingVilleWithSameName != null && existingVilleWithSameName.getId() != idVille) {
		            throw new VilleExistsException("La ville existe déjà pour ce département.");
		        }
			 
			 v.setNom(villeModifiee.getNom());
			 v.setPopulation(villeModifiee.getPopulation());
			 v.setDepartement(villeModifiee.getDepartement());
			 villeRepository.save(v);
		 }
		 return v;
	 }
	
	public List<Ville> supprimerVille(int idVille){
		villeRepository.deleteById(idVille);
		return extractVilles();
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
//	public boolean deleteVilles(int id) {
//		Ville result = villeRepository.findById(id).get();
//		if(result!=null) {
//			villeRepository.deleteById(id);
//			return true;
//		}else {
//			return false;
//		}
//	}
	


	
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
	    departementRepository.save(d1);
	    departementRepository.save(d2);
	    departementRepository.save(d3);
	    departementRepository.save(d4);
	    departementRepository.save(d5);
	    departementRepository.save(d6);
	    departementRepository.save(d7);
	    departementRepository.save(d8);
	    departementRepository.save(d9);
	    departementRepository.save(d10);

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
	
	 public byte[] exportToCsv(List<Ville> villes) throws IOException {
	        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	             CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(out), CSVFormat.DEFAULT.withHeader("Nom", "Nombre d'habitants", "Code département", "Nom du département"))) {

	            for (Ville ville : villes) {
	                csvPrinter.printRecord(ville.getNom(), ville.getPopulation(), ville.getDepartement().getCode(), ville.getDepartement().getNom());
	            }

	            csvPrinter.flush();
	            return out.toByteArray();
	        }
	        }
	

}
