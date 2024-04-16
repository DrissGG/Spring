package com.diginamic.digiHello2.model;





import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity

public class Ville {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/** nom de la ville */
	private String nom;
	/** population totale */
	private int population;
	  
	@ManyToOne
	@NotNull
	@JoinColumn(name = "departement_id")
	private Departement departement;
	
	public Ville() {
		super();
	}	
	

	public Ville(String nom, int population, Departement departement) {
		super();
		this.nom = nom;
		this.population = population;
		this.departement = departement;
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
	


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}
