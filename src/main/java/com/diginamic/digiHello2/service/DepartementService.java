package com.diginamic.digiHello2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.digiHello2.dto.DepartementDto;
import com.diginamic.digiHello2.mapper.DepartementMapper;
import com.diginamic.digiHello2.model.Departement;
import com.diginamic.digiHello2.repository.DepartementRepository;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    // Méthode pour extraire tous les départements
    public List<DepartementDto> extractDepartements() {
        List<Departement> departements = departementRepository.findAll();
        return departements.stream().map(DepartementMapper::toDto).collect(Collectors.toList());
    }

    // Méthode pour extraire un département par son ID
    public DepartementDto extractDepartement(Long id) {
        Departement departement = departementRepository.findById(id).orElse(null);
        if (departement != null) {
            return DepartementMapper.toDto(departement);
        }
        return null;
    }

    public Departement insertDepartement(DepartementDto departementDto) {
    	Departement departement = new Departement();
        departement.setNom(departementDto.getNomDepartement());
        departement.setCode(departementDto.getCodeDepartement());
     
        return departementRepository.save(departement);
    }

    public Departement modifyDepartement(Long id, DepartementDto departementDto) {
        Departement existingDepartement = departementRepository.findById(id).orElse(null);
        if (existingDepartement != null) {
            existingDepartement.setNom(departementDto.getNomDepartement());
            existingDepartement.setCode(departementDto.getCodeDepartement());
            return departementRepository.save(existingDepartement);
        }
        return null;
    }

    public boolean deleteDepartement(Long id) {
        if (departementRepository.existsById(id)) {
            departementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
