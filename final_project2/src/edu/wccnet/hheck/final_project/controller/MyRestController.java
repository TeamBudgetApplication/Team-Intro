package edu.wccnet.hheck.final_project.controller;

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

import edu.wccnet.hheck.final_project.entity.Checkout;
import edu.wccnet.hheck.final_project.entity.Customer;
import edu.wccnet.hheck.final_project.entity.Movie;
import edu.wccnet.hheck.final_project.service.CheckoutService;
import edu.wccnet.hheck.final_project.service.CustomerService;
import edu.wccnet.hheck.final_project.service.MovieService;

@RestController
@RequestMapping("/api")
public class MyRestController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CheckoutService checkoutService;
	@Autowired
	private MovieService movieService;
	
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/checkouts")
	public List<Checkout> getCheckouts(){
		return checkoutService.getCheckouts();
	}
	
	@GetMapping("/movies")
	public List<Movie> getMovies(){
		return movieService.getMovies();
	}
	
	@GetMapping("/customers/{customerID}")
	public Customer getCustomer(@PathVariable int customerID){
		return customerService.getCustomer(customerID);
	}
	
	@GetMapping("/checkouts/{checkoutID}")
	public Checkout getCheckout(@PathVariable int checkoutID){
		return checkoutService.getCheckout(checkoutID);
	}
	
	@GetMapping("/movies/{movieID}")
	public Movie getMovie(@PathVariable int movieID){
		return movieService.getMovie(movieID);
	}
	
	@GetMapping("/movies/title/{title}")
	public Movie getMovieTitle(@PathVariable String title){
		return movieService.getMovie(title);
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PostMapping("/checkouts")
	public Checkout addCheckout(@RequestBody Checkout checkout) {
		checkout.setId(0);
		checkoutService.saveCheckout(checkout);
		return checkout;
	}
	
	@PostMapping("/movies")
	public Movie addMovie(@RequestBody Movie movie) {
		movie.setId(0);
		movieService.saveMovie(movie);
		return movie;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/checkouts")
	public Checkout updateCheckout(@RequestBody Checkout checkout) {
		checkoutService.saveCheckout(checkout);
		return checkout;
	}
	
	@PutMapping("/movies")
	public Movie updateMovie(@RequestBody Movie movie) {
		movieService.saveMovie(movie);
		return movie;
	}
	
	@DeleteMapping("/customers/{customerID}")
	public String deleteCustomer(@PathVariable int customerID) {
		Customer customer = customerService.getCustomer(customerID);
		customerService.deleteCustomer(customer);
		return "customer with id: "+customerID+" has been deleted";
	}
	
	@DeleteMapping("/checkouts/{checkoutID}")
	public String deleteCheckout(@PathVariable int checkoutID) {
		Checkout checkout = checkoutService.getCheckout(checkoutID);
		checkoutService.deleteCheckout(checkout);
		return "checkout record with id: "+checkoutID+" has been deleted";
	}
	
	@DeleteMapping("/movies/{movieID}")
	public String deleteMovie(@PathVariable int movieID) {
		Movie movie = movieService.getMovie(movieID);
		movieService.deleteMovie(movie);
		return "movie with id: "+movieID+" has been deleted";
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
