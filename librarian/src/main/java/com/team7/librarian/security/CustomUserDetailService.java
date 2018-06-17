package com.team7.librarian.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.team7.librarian.model.User;
import com.team7.librarian.repository.UserRepository;
import com.team7.librarian.service.impl.LoginAttemptService;

@Service
class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private LoginAttemptService loginAttemptService;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		if (loginAttemptService.isBlock(getClientIP())) {
			throw new RuntimeException("blocked");
		}
		User user = userRepository.findByEmail(email);
		if (user == null)
			throw new UsernameNotFoundException("Not found user with email :"+email);
		List<GrantedAuthority> authorities = getAuthorities(user);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, authorities);
	}
	
	private List<GrantedAuthority> getAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return authorities;
	}
	
	private String getClientIP() {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null){
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
