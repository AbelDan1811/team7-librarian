package com.team7.librarian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team7.librarian.model.User;
import com.team7.librarian.service.SecurityService;

@Controller
public class MainController {
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/home")
	public String home(RedirectAttributes redirectAttributes) {
		User currentUser = securityService.getLoggedInUser();
		if (currentUser.getRole().equals("ADMIN"))
			return "redirect:/librarian";
		else 
			return "redirect:/user";
	}
}
