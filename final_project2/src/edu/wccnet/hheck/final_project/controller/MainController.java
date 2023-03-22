package edu.wccnet.hheck.final_project.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.hheck.final_project.entity.Checkout;
import edu.wccnet.hheck.final_project.entity.Customer;
import edu.wccnet.hheck.final_project.entity.Movie;
import edu.wccnet.hheck.final_project.service.CheckoutService;
import edu.wccnet.hheck.final_project.service.CustomerService;
import edu.wccnet.hheck.final_project.service.MovieService;

@Controller
@RequestMapping("/login")
public class MainController {
	
	@Autowired
	CheckoutService checkoutService;
	@Autowired
	CustomerService customerService;
	@Autowired
	MovieService movieService;
	
	LocalDateTime currentTime = LocalDateTime.parse(LocalDateTime.now().toString());
	String dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
			  .format(currentTime);
	
	@GetMapping("/checkoutHistory")
	public String listCheckouts(Model model,  @RequestParam("customerID") int id) {
		model.addAttribute("customer", customerService.getCustomer(id));
		model.addAttribute("checkouts",checkoutService.getCheckouts(id));
		return "checkout-history";
	}
	
	@GetMapping("/movieSearch")
	public String searchMovies(Model model,  @RequestParam("customerID") int id) {
		Checkout checkout = new Checkout();
		model.addAttribute("movies",movieService.getMovies());
		model.addAttribute("checkout",checkout);
		model.addAttribute("customer", customerService.getCustomer(id));
		return "movie-search";
	}
	
	@GetMapping("/titleSearch")
	public String titleSearch(Model model, @RequestParam("customerID") int id) {
		model.addAttribute("customer", customerService.getCustomer(id));
		return "enter-title";
	}
	
	@GetMapping("/searchResults")
	public String searchResults(Model model, @RequestParam("title") String title, @RequestParam("customerID") int id) {
		//List<Movie> movies = movieService.getMovies(title);
		Movie movie = movieService.getMovie(title);
		model.addAttribute("movie",movie);
		model.addAttribute("customer", customerService.getCustomer(id));
		return "searched-movie";
		//return "search-list";
	}
	
	@PostMapping("/checkoutMovie")
	public String checkoutMovie(Model model,  @RequestParam("customerID") int id, @RequestParam("movieID") int movieID) {
		Customer customer = customerService.getCustomer(id);
		Movie movie = movieService.getMovie(movieID);
		checkoutService.checkoutMovie(movie, customer);
		model.addAttribute("customer", customerService.getCustomer(id));
		model.addAttribute("checkouts",checkoutService.getCheckouts(id));
		return "checkout-history";
	}
	
	@PostMapping("/returnMovie")
	public String returnMovie(Model model,  @RequestParam("customerID") int id, @RequestParam("checkoutID") int checkoutID) {
		checkoutService.returnCheckout(checkoutID);
		model.addAttribute("customer", customerService.getCustomer(id));
		model.addAttribute("checkouts",checkoutService.getCheckouts(id));
		return "checkout-history";
	}
	
}
