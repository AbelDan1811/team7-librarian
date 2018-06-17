package com.team7.librarian.service;

import java.util.List;

import com.team7.librarian.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public List<User> findUserByName(String name);
	public void save(User user);
}
