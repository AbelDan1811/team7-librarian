package com.team7.librarian.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team7.librarian.model.Cart;
import com.team7.librarian.model.Customer;
import com.team7.librarian.model.User;

public interface CartRepository extends JpaRepository<Cart, Long>{
	public Cart findCartById(Long id);
	public List<Cart> findByOwner(Customer user);
	public List<Cart> findByCreated(Date date);
}
