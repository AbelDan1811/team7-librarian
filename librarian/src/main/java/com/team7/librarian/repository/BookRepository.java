package com.team7.librarian.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team7.librarian.model.Book;

public interface BookRepository  extends JpaRepository<Book, Long>{
	public List<Book> findByTitle(String title);
	public List<Book> findByAuthor(String author);
	public List<Book> findByPublisher(String publisher);
	public Book findBookById(Long id);
	public Book findByTitleAndAuthorAndPublisher(String title, String author, String publisher);
}
