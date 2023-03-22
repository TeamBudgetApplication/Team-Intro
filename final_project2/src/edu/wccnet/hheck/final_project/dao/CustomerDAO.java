package edu.wccnet.hheck.final_project.dao;

import java.util.List;

import edu.wccnet.hheck.final_project.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	void deleteCustomer(Customer customer);

}
