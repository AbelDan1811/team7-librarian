package com.team7.librarian.controller;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team7.librarian.form.NewBookForm;
import com.team7.librarian.model.Book;
import com.team7.librarian.model.BookCopy;
import com.team7.librarian.model.Genre;
import com.team7.librarian.repository.BookCopyRepository;
import com.team7.librarian.service.BookService;
import com.team7.librarian.service.GenreService;

@RestController
@RequestMapping("api/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private BookCopyRepository bookCopyRepository;
	@Autowired
	private GenreService genreService;
	
	@GetMapping(value = {""})
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<List<Book>>(bookService.findAllBooks(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{book_slug:.+}"})
	public ResponseEntity<Book> getBookBySlug(@PathVariable(value="book_slug", required = true) String bookSlug){
		return new ResponseEntity<Book>(bookService.findBookBySlug(bookSlug), HttpStatus.OK);
	}
	
//	@GetMapping(value = {"/{title:[a-z//-]+"})
//	public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable(value = "title", required = true) String title){
//		return new ResponseEntity<List<Book>>(bookService.findBooksByTitle(title), HttpStatus.OK);
//	}
	
	@GetMapping(value = {"/author/{author_name}"})
	public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable(value = "author_name", required = true) String authorName){
		return new ResponseEntity<List<Book>>(bookService.findBooksByAuthor(authorName), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/publisher/{publiser_name}"})
	public ResponseEntity<List<Book>> getBooksByPublisher(@PathVariable(value = "publisher_name", required = true) String publisherName){
		return new ResponseEntity<List<Book>>(bookService.findBooksByPublisher(publisherName), HttpStatus.OK);
	}
	
	
	@PostMapping(value = {""})
	public ResponseEntity<Void> addNewBook(NewBookForm bookForm ){
		Book newBook;
		boolean notFound = false;
		newBook = bookService.findByTitleAndAuthorAndPublisher(bookForm.getTitle(), bookForm.getAuthor(), bookForm.getPublisher());
		if( newBook == null) {
			notFound = true;
			newBook = new Book();
		}
		System.out.println(notFound);
		System.out.println(newBook);
		newBook.setTitle(bookForm.getTitle());
		newBook.setAuthor(bookForm.getAuthor());
		newBook.setPublisher(bookForm.getPublisher());
		String number = bookForm.getCopies();
		List<BookCopy> copies = new ArrayList<>();
		for (int i=0;i<Integer.parseInt(number);i++) {
			BookCopy copy = new BookCopy();
			copy.setTaken(false);
			copy.setBook(newBook);
			bookCopyRepository.save(copy);
			copies.add(copy);
		}
		if (notFound == false) {
			copies.addAll(newBook.getCopies());
			newBook.setCopies(copies);
			newBook.setNumber(Long.valueOf(number)+newBook.getNumber());
			newBook.setAvailable(Long.valueOf(number)+ newBook.getAvailable());
		}
		else {
			newBook.setCopies(copies);
			newBook.setNumber(Long.valueOf(number));
			newBook.setAvailable(Long.valueOf(number));
		}
		if (bookForm.getGenre() != null && bookForm.getGenre().isEmpty() == false) {
			Genre genre = genreService.findGenreByType(bookForm.getGenre());
			newBook.addGenre(genre);
			genre.addBook(newBook);
		}
		newBook.setChosen(Long.valueOf(0));	
		bookService.save(newBook);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
}
