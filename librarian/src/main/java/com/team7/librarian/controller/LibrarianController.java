package com.team7.librarian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team7.librarian.form.NewBookForm;
import com.team7.librarian.model.Book;
import com.team7.librarian.model.Cart;
import com.team7.librarian.model.User;
import com.team7.librarian.service.BookService;
import com.team7.librarian.service.CartService;
import com.team7.librarian.service.SecurityService;

@Controller
@RequestMapping("/librarian")
public class LibrarianController {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired 
	private CartService cartService;
	
	@GetMapping(value = {""})
	public String mainLibrarianPage(Model model) {
		String username = securityService.getLoggedInUser().getFullName();
		model.addAttribute("username",username);
		return "librarianHomePage";
	}
	
	@GetMapping(value = {"/carts"})
	public String addNewCarts(Model model) {
		return "cartPage";
	}
	
	@GetMapping(value  = {"/books"})
	public String showBooks(Model model) {
		return "bookPage";
	}
	
	@GetMapping(value = {"/new-book"})
	public String addNewBook(Model model) {
		return "newBook";
	}
	
	@GetMapping(value= {"/book-detail/{book_slug:.+}"})
	public String showBookDetail(Model model, @PathVariable(value="book_slug", required=true) String bookSlug) {
		model.addAttribute("slug", bookSlug);
		return "bookDetailPage";
	}
	
	@GetMapping(value = {"/new-cart"})
	public String addNewCart(Model model) {
		return "newCart";
	}
	

	
}
