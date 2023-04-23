package edu.wccnet.hheck.final_project.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="checkouts")
public class Checkout {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = Customer.class, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	@ManyToOne(targetEntity = Movie.class, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name="mov_id")
	private Movie movie;
	
	@Column(name="checkout_date")
	private String checkoutDate;
	
	@Column(name="return_date")
	private String returnDate;

	public Checkout() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Checkout(Customer customer, Movie movie, String checkoutDate, String returnDate) {
		super();
		this.customer = customer;
		this.movie = movie;
		this.checkoutDate = checkoutDate;
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Checkout [id=" + id + ", customer=" + customer + ", movie=" + movie + ", checkoutDate=" + checkoutDate
				+ ", returnDate=" + returnDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}
