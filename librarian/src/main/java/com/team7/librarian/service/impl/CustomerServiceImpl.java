package com.team7.librarian.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team7.librarian.model.Customer;
import com.team7.librarian.repository.CustomerRepository;
import com.team7.librarian.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public Customer findByContactNumber(String contactNumber) {
		return customerRepository.findByContactNumber(contactNumber);
	}

	@Override
	public Customer findByFullName(String fullName) {
		return customerRepository.findByFullName(fullName);
	}

	@Override
	public Customer findByLastPassBy(Date date) {
		return customerRepository.findByLastPassBy(date);
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public void save(Customer customer) {
		customer.setLastPassBy(new java.util.Date());
		customerRepository.save(customer);
	}

}
