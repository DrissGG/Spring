package com.diginamic.digiHello2.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.digiHello2.dto.DepartementDto;
import com.diginamic.digiHello2.mapper.DepartementMapper;
import com.diginamic.digiHello2.model.Departement;
import com.diginamic.digiHello2.repository.DepartementRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class DepartementService {
	@PersistenceContext
    private EntityManager em;
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
    public DepartementDto extractDepartementByCode(String code) {
        Departement departement = departementRepository.findByCode(code);
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
    
    @Transactional
    public byte[] exportToCsv(List<DepartementDto> departements) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(out), CSVFormat.DEFAULT.withHeader("Code département", "Nom du département"))) {

            for (DepartementDto departementDto : departements) {
                csvPrinter.printRecord(departementDto.getCodeDepartement(), departementDto.getNomDepartement());
            }

            csvPrinter.flush();
            return out.toByteArray();
        }
        }
}
