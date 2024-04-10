package com.diginamic.digiHello2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ville {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/** nom de la ville */
	private String nom;
	/** population totale */
	private int population;
	
	public Ville() {
		super();
	}	
	public Ville(int id,String nom, int population) {
		super();
		this.id = id;
		this.nom = nom;
		this.population = population;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
