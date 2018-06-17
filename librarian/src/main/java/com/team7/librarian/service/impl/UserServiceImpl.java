package com.team7.librarian.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.team7.librarian.model.User;
import com.team7.librarian.repository.UserRepository;
import com.team7.librarian.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findUserByName(String name) {
		List<User> allUsers = userRepository.findAll();
		ArrayList<User> result = new ArrayList<>();
		for (User user : allUsers) { 
			if (user.getFullName().toLowerCase().contains(name.toLowerCase()))
				result.add(user);
		}
		return result;
	}

	@Override
	public void save(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		if (user.getPassword() != null && !user.getPassword().isEmpty())
					user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		if (user.getEmail().contains("edu.vn"))
			user.setRole("ADMIN");
		else
			user.setRole("USER");
		userRepository.save(user);
	}

}
