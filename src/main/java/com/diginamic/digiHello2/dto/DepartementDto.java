package com.diginamic.digiHello2.dto;

public class DepartementDto {
	
	public DepartementDto() {
		super();
	}
	private String codeDepartement;
	 private String nomDepartement;
	 private int nombreHabitants;
	 
	 public DepartementDto(String codeDepartement, String nomDepartement) {
			super();
			this.codeDepartement = codeDepartement;
			this.nomDepartement = nomDepartement;
		}
	   
	 
	public String getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	public String getNomDepartement() {
		return nomDepartement;
	}
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	public int getNombreHabitants() {
		return nombreHabitants;
	}
	public void setNombreHabitants(int nombreHabitants) {
		this.nombreHabitants = nombreHabitants;
	}
}
