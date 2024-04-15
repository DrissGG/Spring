package com.diginamic.digiHello2.controleurs;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.diginamic.digiHello2.service.VilleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VilleControllerTest {
	 	@Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private VilleService villeService;

	   
	    @Test
	    public void testInsertVille() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.post("/villes")
	                .content("{ \"nom\": \"Paris\", \"population\": 10000, \"departement\": { \"code\": \"75\", \"nom\": \"Paris\" } }")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk());
	    }
	    
	    @Test
	    public void testInvalidVille() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.post("/villes")
	                .content("{ \"nom\": \"P\", \"population\": 5, \"departement\": { \"code\": \"7\", \"nom\": \"Pa\" } }")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isBadRequest())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.errors").isArray())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].field").value("nom"))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].message").value("Le nom de la ville doit contenir au moins 2 lettres."))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[1].field").value("population"))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[1].message").value("La ville doit avoir au moins 10 habitants."))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[2].field").value("departement.code"))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[2].message").value("Le code département doit obligatoire avoir 2 caractères"));
	    }
}
