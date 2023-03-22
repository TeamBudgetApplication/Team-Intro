package edu.wccnet.hheck.final_project.service;

import java.util.List;

import edu.wccnet.hheck.final_project.entity.Checkout;
import edu.wccnet.hheck.final_project.entity.Customer;
import edu.wccnet.hheck.final_project.entity.Movie;

public interface CheckoutService {
	
	public List<Checkout> getCheckouts();

	void saveCheckout(Checkout checkout);

	public Checkout getCheckout(int id);

	void deleteCheckout(Checkout checkout);

	public Object getCheckouts(int id);

	public void returnCheckout(int checkoutID);

	public void checkoutMovie(Movie movie, Customer customer);

}
