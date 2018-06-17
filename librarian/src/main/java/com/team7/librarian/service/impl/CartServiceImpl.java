package com.team7.librarian.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team7.librarian.model.Cart;
import com.team7.librarian.model.Customer;
import com.team7.librarian.model.User;
import com.team7.librarian.repository.CartRepository;
import com.team7.librarian.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart findCartById(Long id) {
		return cartRepository.findCartById(id);
	}
	

	@Override
	public List<Cart> getAllCustomerCarts(Customer user) {
		return cartRepository.findByOwner(user);
	}

	@Override
	public List<Cart> getAllCartsByCreatedDate(Date date) {
		return cartRepository.findByCreated(date);
	}

	@Override
	public List<Cart> findAllCarts() {
		List<Cart> allCarts = cartRepository.findAll();
		List<Cart> result = new ArrayList<>();
		for (Cart cart : allCarts) {
			if (cart.getCreated() != null)
				result.add(cart);
		}
		Collections.sort(result, Cart.dateComparator);
		return result;
	}

	@Override
	public void resolveCart(Long cartId) {
		Cart resolvedCart = cartRepository.findCartById(cartId);
		resolvedCart.setReturned(true);
		
	}

	@Override
	public void save(Cart cart) {
		cart.setReturned(false);
		cart.setCreated(new java.util.Date());
		cartRepository.save(cart);
	}


	@Override
	public List<Cart> findAllUnresolvedCarts() {
		List<Cart> allCarts = cartRepository.findAll();
		List<Cart> result = new ArrayList<>();
		for (Cart cart : allCarts) {
			if (cart.isReturned() == false && cart.getCreated() != null)
				result.add(cart);
		}
		Collections.sort(result, Cart.dateComparator);
		return result;
	}

}
