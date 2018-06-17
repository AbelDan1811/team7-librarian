package com.team7.librarian.service;

import java.sql.Date;
import java.util.List;

import com.team7.librarian.model.Cart;
import com.team7.librarian.model.Customer;
import com.team7.librarian.model.User;

public interface CartService {
	public Cart findCartById(Long id);
	public List<Cart> getAllCustomerCarts(Customer customer);
	public List<Cart> getAllCartsByCreatedDate(Date date);
	public List<Cart> findAllCarts();
	public void resolveCart(Long id);
	public void save(Cart cart);
	public List<Cart> findAllUnresolvedCarts();
}
