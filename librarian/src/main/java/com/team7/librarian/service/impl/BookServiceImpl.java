package com.team7.librarian.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team7.librarian.model.Book;
import com.team7.librarian.repository.BookRepository;
import com.team7.librarian.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> findBooksByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	@Override
	public List<Book> findBooksByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> findBooksByPublisher(String publisher) {
		return bookRepository.findByPublisher(publisher);
	}

	@Override
	public Book findBookBySlug(String slug) {
		List<Book> allBooks = bookRepository.findAll();
		for (Book book : allBooks) {
			if (book.getSlug().equals(slug))
				return book;
		}
		return null;
 	}

	@Override
	public Book findBookById(Long id) {
		return bookRepository.findBookById(id);
	}

	@Override
	public void save(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> list = bookRepository.findAll();
		return list;
	}

	@Override
	public Book findByTitleAndAuthorAndPublisher(String title, String author, String publisher) {
		return bookRepository.findByTitleAndAuthorAndPublisher(title, author, publisher);
	}

	

}
