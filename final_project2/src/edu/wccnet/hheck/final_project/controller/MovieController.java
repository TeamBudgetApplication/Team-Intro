package edu.wccnet.hheck.final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.hheck.final_project.entity.Movie;
import edu.wccnet.hheck.final_project.entity.MovieOptions;
import edu.wccnet.hheck.final_project.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	MovieOptions movieOptions;
	
	@GetMapping("/list")
	public String listMovies(Model model) {
		model.addAttribute("movies",movieService.getMovies());
		return "list-movies";
	}
	
	@PostMapping("/addMovie")
	public String addMovie(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "add-movie";
	}
	
	@PostMapping("/processMovie")
	public String processMovie(@ModelAttribute("movie") Movie movie) {
		movieService.saveMovie(movie);
		return "redirect:/movie/list";
	}
	
	@RequestMapping("/updateMovie")
	public String updateMovie(Model model, @RequestParam("movieID") int id) {
		Movie movie = movieService.getMovie(id);
		model.addAttribute(movie);
		return "add-movie";
	}
	
	@RequestMapping("/deleteMovie")
	public String deleteMovie( @RequestParam("movieID") int id) {
		Movie movie = movieService.getMovie(id);
		movieService.deleteMovie(movie);
		return "redirect:/movie/list";
	}
	
	@ModelAttribute
	public void populateFormWithData(Model model) {
		model.addAttribute("genreList",movieOptions.populateGenres());
	}
}
