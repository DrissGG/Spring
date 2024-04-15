package com.diginamic.digiHello2.runner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.stereotype.Component;

import com.diginamic.digiHello2.DigiHello2Application;
import com.diginamic.digiHello2.dto.DepartementDto;
import com.diginamic.digiHello2.model.Departement;
import com.diginamic.digiHello2.service.DepartementService;
import com.diginamic.digiHello2.service.VilleService;

@Component
public class MyCommandeLineRunner implements CommandLineRunner{
	
	 	@Autowired
	    private DepartementService departementService;

	    @Autowired
	    private VilleService villeService;
	    
	public static void main(String[] args) {
//		SpringApplication.run(DigiHello2Application.class, args);
		SpringApplication sa = new SpringApplication(DigiHello2Application.class);
		sa.setWebApplicationType(WebApplicationType.NONE);
		sa.run(args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		String csvFile = "cities.csv";
        String line;
        String cvsSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			br.readLine();
        	while((line = br.readLine()) != null) {
        		String[] data = line.split(cvsSplitBy);
        		String cityName = data[1];
//                int population = Integer.parseInt(data[1]);
                String departmentCode = data[7];
                String departmentName = data[6];
                
                DepartementDto departementdto = new DepartementDto();
                
                departementdto.setNomDepartement(departmentName);
                departementdto.setCodeDepartement(departmentCode);
                
                DepartementDto departement = departementService.extractDepartementByCode(departmentCode);
                if (departement == null) {
                	departement = new DepartementDto(departmentCode,departmentName);
                	departementService.insertDepartement(departement);
                }
                    
                
                
                
        	}
		} catch (Exception e) {
			// Gérer les erreurs de chargement de données
            e.printStackTrace();
		}
		
	}
	

}
