package com.team7.librarian.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="bookcopy")
public class BookCopy {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinTable(name="bookcopy_book", 
				joinColumns= @JoinColumn(name = "bookcopy_id", referencedColumnName="id"), 
				inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
	private Book book;
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinTable(name="bookcopy_customer", 
				joinColumns= @JoinColumn(name = "bookcopy_id", referencedColumnName="id"), 
				inverseJoinColumns = @JoinColumn(name = "owner_id", referencedColumnName = "id"))
	private Customer owner;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinTable(name="bookcopy_cart", 
				joinColumns= @JoinColumn(name = "bookcopy_id", referencedColumnName="id"), 
				inverseJoinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"))
	@JsonIgnore
	private Cart cart;
	
	private boolean taken = false;
	
	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
