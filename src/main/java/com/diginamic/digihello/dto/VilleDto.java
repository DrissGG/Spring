package com.diginamic.digihello.dto;

public class VilleDto {
	
	private String nomVille;
    private int nombreHabitants;
    private String codeDepartement;
    private String nomDepartement;
    
    
	public String getnomVille() {
		return nomVille;
	}
	public void setnomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public int getNombreHabitants() {
		return nombreHabitants;
	}
	public void setNombreHabitants(int nombreHabitants) {
		this.nombreHabitants = nombreHabitants;
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
}
