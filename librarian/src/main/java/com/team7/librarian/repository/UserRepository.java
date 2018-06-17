package com.team7.librarian.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team7.librarian.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public User findByEmail(String email);
}
