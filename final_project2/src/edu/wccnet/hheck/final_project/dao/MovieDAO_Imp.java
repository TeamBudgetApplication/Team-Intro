package edu.wccnet.hheck.final_project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.hheck.final_project.entity.Customer;
import edu.wccnet.hheck.final_project.entity.Movie;

@Repository
public class MovieDAO_Imp implements MovieDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Movie> getMovies() {
		Session session = sessionFactory.getCurrentSession();
		Query<Movie> query = session.createQuery("from Movie order by title", Movie.class);
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveMovie(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(movie);;

	}

	@Override
	@Transactional
	public Movie getMovie(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Movie.class, id);

	}

	@Override
	@Transactional
	public void deleteMovie(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(movie);

	}

	@Override
	@Transactional
	public Movie getMovie(String title) {
		Session session = sessionFactory.getCurrentSession();
		Query<Movie> query = session.createQuery("from Movie where title = :title", Movie.class);
		query.setParameter("title", title);
		Movie movie = query.getSingleResult();
		
		return movie;
		
	}

	@Override
	@Transactional
	public List<Movie> getMovies(String title) {
		Session session = sessionFactory.getCurrentSession();
		Query<Movie> query = session.createQuery("from Movie where title like '%title%'", Movie.class);
		query.setParameter("title", title);
		return query.getResultList();
	}

}
