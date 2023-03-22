package edu.wccnet.hheck.final_project.dao;

import java.util.List;

import edu.wccnet.hheck.final_project.entity.Movie;

public interface MovieDAO {

	public List<Movie> getMovies();

	void saveMovie(Movie movie);

	public Movie getMovie(int id);

	void deleteMovie(Movie movie);

	public Movie getMovie(String title);

	public List<Movie> getMovies(String title);

}
