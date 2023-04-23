package edu.wccnet.hheck.budget_draft.dao;

import java.util.List;

import edu.wccnet.hheck.budget_draft.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	void deleteCustomer(Customer customer);

}
