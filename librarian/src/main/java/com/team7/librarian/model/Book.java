package com.team7.librarian.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Id
	private Long id;
	private String title;
	private String author;
	private String publisher;
	private Long number;
	@JsonIgnore
	private Long chosen;
	
	private Long available;
	

	@OneToMany(mappedBy = "book", cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<BookCopy> copies;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "book_genre",
				joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), 
				inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
	private List<Genre> genres = new ArrayList<>();
	
	@ManyToMany(mappedBy = "items", cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Cart> carts;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getSlug() {
		return String.join("-", title.split(" ")).toLowerCase()+"-" + id.toString();
	}
	public Long getChosen() {
		return chosen;
	}
	public void setChosen(Long chosen) {
		this.chosen = chosen;
	}
	public List<BookCopy> getCopies() {
		return copies;
	}
	public void setCopies(List<BookCopy> copies) {
		this.copies = copies;
	}
	public void addGenre(Genre genre) {
		this.genres.add(genre);
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getAvailable() {
		return available;
	}
	public void setAvailable(Long available) {
		this.available = available;
	}
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public void addCart(Cart cart) {
		this.carts.add(cart);
	}
}
