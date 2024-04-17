package com.diginamic.digihello.controleurs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		Map<String, Object> model = new HashMap<>();
		model.put("villes", villeservices.extractVilles());
		model.put("departements", departementservices.extractDepartements());
		return new ModelAndView("ville/villeList",model);
	}
	
}
