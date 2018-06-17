package com.team7.librarian.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String email;
	
	private String contactNumber;
	
	private String fullName;
	
	private String organization;
	
	private java.util.Date lastPassBy;
	
	@OneToMany(mappedBy = "owner", cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<BookCopy> bookCopies = new ArrayList<>();
	
	@OneToMany(mappedBy = "owner", cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Cart> carts = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public java.util.Date getLastPassBy() {
		return lastPassBy;
	}

	public void setLastPassBy(java.util.Date lastPassBy) {
		this.lastPassBy = lastPassBy;
	}
	
	public void addCart(Cart cart) {
		this.carts.add(cart);
	}
	public void addCopies(List<BookCopy> items) {
		this.bookCopies.addAll(items);
	}
	
}
