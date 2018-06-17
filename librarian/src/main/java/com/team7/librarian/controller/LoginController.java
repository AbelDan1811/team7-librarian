package com.team7.librarian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	
	public static final String BAD_CREDENTIAL_MESSAGE = "Invalid username or password!";
	public static final String LOGOUT_SUCCEEDED_MESSAGE = "You have logged out successfully!";
	public static final String INVALID_SESSION_MESSAGE = "Invalid session!";
	public static final String BLOCKED_AUTH_MESSAGE = "You have been blocked from logging in for 5 minutes";
	public static final String EXPIRED_SESSION_MESSAGE = "Your session has been expired";
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String login(Model model, @RequestParam(value="message",required=false) String message) {
		if (message!=null) {
			if (message.equals("error"))
				model.addAttribute("message", BAD_CREDENTIAL_MESSAGE);
			else if (message.equals("logout"))
				model.addAttribute("message", LOGOUT_SUCCEEDED_MESSAGE);
			else if (message.equals("invalid-session"))
				model.addAttribute("message", INVALID_SESSION_MESSAGE);
			else if (message.equals("blocked"))
				model.addAttribute("message", BLOCKED_AUTH_MESSAGE);
			else if (message.equals("expried-session"))
				model.addAttribute("message", EXPIRED_SESSION_MESSAGE);
		}
		return "login";
	}
	
	
}
