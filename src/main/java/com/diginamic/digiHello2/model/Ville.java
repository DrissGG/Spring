package com.diginamic.digiHello2.model;

public class Ville {
	/** nom de la ville */
	private String nom;
	/** population totale */
	private int population;
	
	public Ville(String nom, int population) {
		super();
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

}
