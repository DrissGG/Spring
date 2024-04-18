package com.diginamic.digihello.controleurs;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.diginamic.digihello.service.DepartementService;
import com.diginamic.digihello.service.VilleService;

@Controller
public class VilleViewControleur {
	@Autowired
	VilleService villeservices;
	@Autowired
	DepartementService departementservices;
	
	
	@GetMapping("/villes")
	public ModelAndView getVilles() {
		Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
		Map<String, Object> model = new HashMap<>();
		model.put("villes", villeservices.extractVilles());
		model.put("departements", departementservices.extractDepartements());
		 model.put("authorities", authentication.getAuthorities());
		return new ModelAndView("ville/villeList",model);
	}
	
	@GetMapping("/supprimerVille/{id}")
    public ResponseEntity<?> deleteVilles(@PathVariable int id) {
		villeservices.supprimerVille(id);
        return ResponseEntity.ok().build();
    }
	
}
