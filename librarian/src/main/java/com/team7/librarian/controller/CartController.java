package com.team7.librarian.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team7.librarian.form.NewCartForm;
import com.team7.librarian.model.Book;
import com.team7.librarian.model.BookCopy;
import com.team7.librarian.model.Cart;
import com.team7.librarian.model.Customer;
import com.team7.librarian.model.Genre;
import com.team7.librarian.model.User;
import com.team7.librarian.repository.CartRepository;
import com.team7.librarian.service.BookService;
import com.team7.librarian.service.CartService;
import com.team7.librarian.service.CustomerService;

@RestController
@RequestMapping("/api/carts")
public class CartController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping(value= {""})
	public ResponseEntity<List<Cart>> getAllCarts(){
		return new ResponseEntity<List<Cart>>(cartService.findAllCarts(), HttpStatus.OK);
	}
	@PostMapping(value={"/resolve/{cartId}"})
	public ResponseEntity<Void> resolveCart(@PathVariable("cartId") Long id){
		Cart cart = cartService.findCartById(id);
		cartRepository.delete(cart);
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value= {""})
	public ResponseEntity<Void> addNewCart(@RequestBody NewCartForm newCartForm){
		Customer currenCustomer = customerService.findByEmail(newCartForm.getEmail());
		if (currenCustomer == null) {
			currenCustomer = new Customer();
		}
		currenCustomer.setEmail(newCartForm.getEmail());
		currenCustomer.setFullName(newCartForm.getFullName());
		currenCustomer.setContactNumber(newCartForm.getContactNumber());
		currenCustomer.setOrganization(newCartForm.getOrganization());
		
		
		
		Cart newCart = new Cart();
		List<Book> items = this.getBooks(newCartForm.getPickup(), newCart);
		newCart.setOwner(currenCustomer);
		newCart.setItems(items);
		newCart.setCreated(new Date());
		newCart.setReturned(false);
		currenCustomer.addCart(newCart);
		customerService.save(currenCustomer);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	private List<Book> getBooks(List<String> pickUp , Cart currentCart){
		List<Book> books = new ArrayList<>();
		for (String title : pickUp) {
			Book book = bookService.findBooksByTitle(title).get(0);
			book.addCart(currentCart);
			book.setChosen(book.getChosen() + 1);
			book.setAvailable(book.getAvailable() - 1);
			bookService.save(book);
			books.add(book);
		}
		return books;
	}
	
	
}
