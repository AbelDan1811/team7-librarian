package com.team7.librarian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.team7.librarian.model.User;
import com.team7.librarian.repository.UserRepository;
import com.team7.librarian.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService{
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getLoggedInUser() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepository.findByEmail(email);
	}
	
	@Override
	public void setSecurityContext(User user) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
		Authentication auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		
	}
}
