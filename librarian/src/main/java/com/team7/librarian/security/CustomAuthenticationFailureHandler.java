package com.team7.librarian.security;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException , ServletException {
		setDefaultFailureUrl("/login?error=true");
		
		String errorMessage = "Invalid username or password !";
		
		if(exception.getMessage() != null && exception.getMessage().equalsIgnoreCase("blocked"))
			errorMessage = "This IP address has been locked !";
		
		request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorMessage);
		
	}
}
