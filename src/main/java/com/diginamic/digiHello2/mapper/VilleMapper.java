package com.diginamic.digiHello2.mapper;

import com.diginamic.digiHello2.dto.VilleDto;
import com.diginamic.digiHello2.model.Ville;

public class VilleMapper {
	public static VilleDto toDto(Ville ville) {
        VilleDto villeDto = new VilleDto();
        villeDto.setCodeVille(ville.getDepartement().getCode());
        villeDto.setNombreHabitants(ville.getPopulation());
        villeDto.setCodeDepartement(ville.getDepartement().getCode());
        villeDto.setNomDepartement(ville.getDepartement().getNom());
        return villeDto;
    }
}
