package edu.wccnet.hheck.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.hheck.final_project.controller.NotFoundException;
import edu.wccnet.hheck.final_project.dao.MovieDAO;
import edu.wccnet.hheck.final_project.entity.Movie;

@Service
public class MovieService_Imp implements MovieService {
	
	@Autowired
	MovieDAO movieDAO;
	
	@Override
	@Transactional
	public List<Movie> getMovies() {
		return movieDAO.getMovies();
	}

	@Override
	@Transactional
	public void saveMovie(Movie movie) {
		movieDAO.saveMovie(movie);

	}

	@Override
	@Transactional
	public Movie getMovie(int id) {
		Movie movie  = movieDAO.getMovie(id);
		if (movie == null) {
			throw new NotFoundException("movie not found for id: "+id);
		}
		return movie;
	}

	@Override
	@Transactional
	public void deleteMovie(Movie movie) {
		if (movie == null) {
			throw new NotFoundException("movie not found");
		}
		movieDAO.deleteMovie(movie);
	}

	@Override
	@Transactional
	public Movie getMovie(String title) {
		Movie movie  = movieDAO.getMovie(title);
		if (movie == null) {
			throw new NotFoundException("movie not found for title: "+title);
		}
		return movie;
	}

	@Override
	@Transactional
	public List<Movie> getMovies(String title) {
		return movieDAO.getMovies(title);
	}

}
