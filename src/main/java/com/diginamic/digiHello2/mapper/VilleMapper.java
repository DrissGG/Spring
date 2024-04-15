package com.diginamic.digiHello2.mapper;

import com.diginamic.digiHello2.dto.DepartementDto;
import com.diginamic.digiHello2.dto.VilleDto;
import com.diginamic.digiHello2.model.Departement;
import com.diginamic.digiHello2.model.Ville;

public class VilleMapper {
	public static VilleDto toDto(Ville ville) {
        VilleDto villeDto = new VilleDto();
        
        villeDto.setnomVille(ville.getNom());
        villeDto.setNombreHabitants(ville.getPopulation());
        villeDto.setCodeDepartement(ville.getDepartement().getCode());
        villeDto.setNomDepartement(ville.getDepartement().getNom());
        return villeDto;
    }

	public static Ville toBean(VilleDto vdto) {
		Ville v = new Ville();
		DepartementDto d = new DepartementDto();
		
		 // Mapping des attributs communs
	    v.setNom(vdto.getnomVille());
	    v.setPopulation(vdto.getNombreHabitants());

	    // Mapping des attributs du département
	    d.setCodeDepartement(vdto.getCodeDepartement());
	    d.setNomDepartement(vdto.getNomDepartement());
	    
	    Departement dd = toBean(d);
	    
	    // Attribution du département à la ville
	    v.setDepartement(dd);
	    
	    return v;

	}
	
	public static Departement toBean(DepartementDto ddto) {
	    Departement d = new Departement();

	    // Mapping des attributs communs
	    d.setCode(ddto.getCodeDepartement());
	    d.setNom(ddto.getNomDepartement());
	    

	    return d;
	}

}
