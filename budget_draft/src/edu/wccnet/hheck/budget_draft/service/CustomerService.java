package edu.wccnet.hheck.budget_draft.service;

import java.util.List;

import edu.wccnet.hheck.budget_draft.entity.Customer;


public interface CustomerService {

	public List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	void deleteCustomer(Customer customer);

	public List<Customer> getCustomers(Object object);

}
