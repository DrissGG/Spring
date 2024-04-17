package com.diginamic.digihello.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.diginamic.digihello.model.Departement;
import com.diginamic.digihello.model.Ville;
import com.diginamic.digihello.repository.VilleRepository;
import com.diginamic.digihello.service.VilleService;


@SpringBootTest
public class VilleServiceTest {
	@Mock
    private VilleRepository villeRepository;

    @InjectMocks
    private VilleService villeService;
    
	@Test
	public void testextractVille() {
		// Création de données de test
        Ville ville1 = new Ville("Ville 1", 10000, new Departement("34", "Herault"));
        Ville ville2 = new Ville("Ville 2", 20000, new Departement("75", "Paris"));
        
        List<Ville> villes = new ArrayList<>();
        villes.add(ville1);
        villes.add(ville2);
        
        // Définir le comportement attendu pour le mock du repository
        when(villeRepository.findAll()).thenReturn(villes);

        // Appel de la méthode à tester
        List<Ville> result = villeService.extractVilles();

        // Vérifier le résultat
        assertEquals(2, result.size()); // Vérifie que la liste retournée contient deux éléments
        assertEquals("Ville 1", result.get(0).getNom()); // Vérifie le premier élément de la liste
        assertEquals("Ville 2", result.get(1).getNom()); // Vérifie le deuxième élément de la liste
            
        
	}

}
