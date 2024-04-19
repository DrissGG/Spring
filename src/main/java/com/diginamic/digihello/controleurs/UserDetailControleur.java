package com.diginamic.digihello.controleurs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("/")
public class UserDetailControleur {
	
	@GetMapping
	public ModelAndView getIndex() {
		Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        Map<String, Object> model = new HashMap<>();
        if (authentication != null && authentication.isAuthenticated()) {
            model.put("username", authentication.getName());
            model.put("authorities", authentication.getAuthorities());
            
        }
        return new ModelAndView("index", model);
	}
	
	@GetMapping("/loginSuccess")
    public String loginSuccess(OAuth2AuthenticationToken authentication) {
        return "redirect:/index";
    }
}
