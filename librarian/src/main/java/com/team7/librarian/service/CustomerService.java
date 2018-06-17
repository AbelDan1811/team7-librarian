package com.team7.librarian.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.team7.librarian.model.Customer;


public interface CustomerService {
	public Customer findByEmail(String email);
	public Customer findByContactNumber(String contactNumber);
	public Customer findByFullName(String fullName);
	public Customer findByLastPassBy(Date date);
	public Optional<Customer> findById(Long id);
	public List<Customer> findAll();
	public void save(Customer customer);
	
}
