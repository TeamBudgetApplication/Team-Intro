package edu.wccnet.hheck.budget_draft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.hheck.budget_draft.entity.Customer;
import edu.wccnet.hheck.budget_draft.service.CustomerService;

@RestController
@RequestMapping("/api")
public class MyRestController {

	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerID}")
	public Customer getCustomer(@PathVariable int customerID){
		return customerService.getCustomer(customerID);
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{customerID}")
	public String deleteCustomer(@PathVariable int customerID) {
		Customer customer = customerService.getCustomer(customerID);
		customerService.deleteCustomer(customer);
		return "customer with id: "+customerID+" has been deleted";
	}
	
	@ExceptionHandler
	public ResponseEntity<MyAPIErrorResponse> handleException(NotFoundException e){
		MyAPIErrorResponse error = new MyAPIErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyAPIErrorResponse> handleException(Exception e){
		MyAPIErrorResponse error = new MyAPIErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
