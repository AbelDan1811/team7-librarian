package com.team7.librarian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team7.librarian.model.User;
import com.team7.librarian.service.SecurityService;
import com.team7.librarian.service.UserService;


@Controller
public class RegistrationController {
	@Autowired
	private UserService userService;
	@Autowired 
	private SecurityService securityService;
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showRegistration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String handleRegistration(Model model, @ModelAttribute("userForm") User userForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		User userExisted = userService.findUserByEmail(userForm.getEmail());
		if (userExisted != null) {
			model.addAttribute("userExistedMessage", "Username has already existed!");
			bindingResult.reject("username");
			return "registration";
		}
		if (bindingResult.hasErrors())
			return "registration";

		userService.save(userForm);
		securityService.setSecurityContext(userForm);
		redirectAttributes.addAttribute("user", securityService.getLoggedInUser().getEmail());
		return "registrationSuccess";
	}
}
