package com.diginamic.digihello.controleurs;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.diginamic.digihello.model.UserAccount;
import com.diginamic.digihello.repository.UserAccountRepository;

@Controller
public class InscriptionController {
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	public String inscription(@RequestParam String username,
							  @RequestParam String password,
							  @RequestParam String email,
							  @RequestParam LocalDate dateOfBirth)
	{
		UserAccount user = new UserAccount(username,password,"ROLE_USER");
		user.setEmail(email);
		user.setDateOfBirth(dateOfBirth);
		
		//Enregistrement dans la base de données
		userAccountRepository.save(user);
		
		
		// Rediriger vers la page de connexion ou une autre page appropriée
        return "redirect:/login"; 
	}
}
