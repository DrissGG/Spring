package com.diginamic.digiHello2.mapper;

import com.diginamic.digiHello2.dto.DepartementDto;
import com.diginamic.digiHello2.model.Departement;
import com.diginamic.digiHello2.model.Ville;

public class DepartementMapper {
	public static DepartementDto toDto(Departement departement) {
        DepartementDto departementDto = new DepartementDto();
        departementDto.setCodeDepartement(departement.getCode());
        departementDto.setNomDepartement(departement.getNom());
        departementDto.setNombreHabitants(departement.getVilles().stream().mapToInt(Ville::getPopulation).sum());
        return departementDto;
    }
}
