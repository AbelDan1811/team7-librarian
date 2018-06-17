package com.team7.librarian.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genre {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@JsonIgnore
	private Long id;
	
	@JsonIgnore
	private Long chosen;
	private String type;
	
	@ManyToMany(mappedBy = "genres", cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Book> books;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Long getChosen() {
		return chosen;
	}
	public void setChosen(Long chosen) {
		this.chosen = chosen;
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
}
