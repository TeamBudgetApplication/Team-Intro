package edu.wccnet.hheck.budget_draft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.hheck.budget_draft.controller.NotFoundException;
import edu.wccnet.hheck.budget_draft.dao.CustomerDAO;
import edu.wccnet.hheck.budget_draft.entity.Customer;



@Service
public class CustomerService_Imp implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);

	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Customer customer = customerDAO.getCustomer(id);
		if (customer == null) {
			throw new NotFoundException("customer not found for id: "+id);
		}
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		if (customer == null) {
			throw new NotFoundException("customer not found");
		}
		customerDAO.deleteCustomer(customer);
	}

	@Override
	public List<Customer> getCustomers(Object object) {
		return customerDAO.getCustomers();
	}

}
