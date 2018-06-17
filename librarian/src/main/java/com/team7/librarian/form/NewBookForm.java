package com.team7.librarian.form;

import java.util.List;

public class NewBookForm {
	private String title;
	private String author;
	private String publisher;
	private String genre;
	private String copies;
	
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCopies() {
		return copies;
	}
	public void setCopies(String copies) {
		this.copies = copies;
	}
	
	public String toString() {
		return this.title + this.author + this.publisher + this.copies + this.genre;
		
	}
	
	
}
