package com.diginamic.digiHello2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.digiHello2.controleurs.VilleControleur;
import com.diginamic.digiHello2.model.Ville;

@Service
public class VilleService {
	@Autowired
    private VilleRepository villeRepository;

	
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
			 villeRepository.save(v);
		 }
		 return extractVilles();
	 }
	public List<Ville> supprimerVille(int idVille){
		villeRepository.deleteById(idVille);
		return extractVilles();
	}

}
