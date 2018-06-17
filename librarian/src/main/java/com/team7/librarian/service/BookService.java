package com.team7.librarian.service;

import java.util.List;

import com.team7.librarian.model.Book;

public interface BookService {
	public List<Book> findBooksByTitle(String title);
	public List<Book> findBooksByAuthor(String author);
	public List<Book> findBooksByPublisher(String publisher);
	public List<Book> findAllBooks();
	public Book findBookBySlug(String slug);
	public Book findBookById(Long id);
	public void save(Book book);
	public Book findByTitleAndAuthorAndPublisher(String title, String author, String publisher);
}
