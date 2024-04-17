package com.diginamic.digihello.mapper;

import com.diginamic.digihello.dto.DepartementDto;
import com.diginamic.digihello.model.Departement;
import com.diginamic.digihello.model.Ville;

public class DepartementMapper {
	public static DepartementDto toDto(Departement departement) {
        DepartementDto departementDto = new DepartementDto();
        departementDto.setCodeDepartement(departement.getCode());
        departementDto.setNomDepartement(departement.getNom());
//        departementDto.setNombreHabitants(departement.getVilles().stream().mapToInt(Ville::getPopulation).sum());
        return departementDto;
    }
}
