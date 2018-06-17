package com.team7.librarian.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team7.librarian.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public Customer findByEmail(String email);
	public Customer findByContactNumber(String contactNumber);
	public Customer findByFullName(String FullName);
	public Customer findByLastPassBy(Date date);
}
