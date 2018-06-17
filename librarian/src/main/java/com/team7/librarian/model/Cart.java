package com.team7.librarian.model;
import java.sql.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinTable(name="cart_customer", 
				joinColumns= @JoinColumn(name = "cart_id", referencedColumnName="id"), 
				inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
	private Customer owner;
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "cart_book",
				joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"), 
				inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
	private List<Book> items = new ArrayList<>();
	
	private boolean returned;
	
	private java.util.Date created;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Customer getOwner() {
		return owner;
	}


	public void setOwner(Customer owner) {
		this.owner = owner;
	}


	public List<Book> getItems() {
		return items;
	}


	public void setItems(List<Book> items) {
		this.items = items;
	}


	public java.util.Date getCreated() {
		return created;
	}


	public void setCreated(java.util.Date created) {
		this.created = created;
	}


	public boolean isReturned() {
		return returned;
	}


	public void setReturned(boolean returned) {
		this.returned = returned;
	}
	
	public static Comparator<Cart> dateComparator = new Comparator<Cart>() {
		public int compare(Cart cart1 , Cart cart2) {
			java.util.Date date1 = cart1.getCreated();
			java.util.Date date2 = cart2.getCreated();
			return date2.compareTo(date1);
		}
	};
	
	
}
