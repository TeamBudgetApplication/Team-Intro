package edu.wccnet.hheck.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.hheck.final_project.controller.NotFoundException;
import edu.wccnet.hheck.final_project.dao.CheckoutDAO;
import edu.wccnet.hheck.final_project.entity.Checkout;
import edu.wccnet.hheck.final_project.entity.Customer;
import edu.wccnet.hheck.final_project.entity.Movie;

@Service
public class CheckoutService_Imp implements CheckoutService {

	@Autowired
	private CheckoutDAO checkoutDAO;
	
	@Override
	@Transactional
	public List<Checkout> getCheckouts() {
		return checkoutDAO.getCheckouts();
	}

	@Override
	@Transactional
	public void saveCheckout(Checkout checkout) {
		checkoutDAO.saveCheckout(checkout);
	}

	@Override
	@Transactional
	public Checkout getCheckout(int id) {
		Checkout checkout = checkoutDAO.getCheckout(id);
		if (checkout == null) {
			throw new NotFoundException("checkout not found for id: "+id);
		}
		return checkout;
	}

	@Override
	@Transactional
	public void deleteCheckout(Checkout checkout) {
		if (checkout == null) {
			throw new NotFoundException("checkout not found");
		}
		checkoutDAO.deleteCheckout(checkout);
	}

	@Override
	@Transactional
	public Object getCheckouts(int id) {
		return checkoutDAO.getCheckouts(id);
	}

	@Override
	@Transactional
	public void returnCheckout(int checkoutID) {
		checkoutDAO.returnCheckout(checkoutID);
		
	}

	@Override
	@Transactional
	public void checkoutMovie(Movie movie, Customer customer) {
		checkoutDAO.checkoutMovie(movie, customer);
		
	}

}
