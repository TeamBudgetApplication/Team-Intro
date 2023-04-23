package edu.wccnet.hheck.final_project.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.hheck.final_project.entity.Checkout;
import edu.wccnet.hheck.final_project.entity.Customer;
import edu.wccnet.hheck.final_project.entity.Movie;

@Repository
public class CheckoutDAO_Imp implements CheckoutDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	@Transactional
	public List<Checkout> getCheckouts() {
		Session session = sessionFactory.getCurrentSession();
		Query<Checkout> query = session.createQuery("from Checkout", Checkout.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveCheckout(Checkout checkout) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(checkout);
	}

	@Override
	@Transactional
	public Checkout getCheckout(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Checkout.class, id);
	}

	@Override
	@Transactional
	public void deleteCheckout(Checkout checkout) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(checkout);
	}

	@Override
	@Transactional
	public Object getCheckouts(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer where id = :id");
		query.setParameter("id", id);
		Customer customer = query.getSingleResult();
		
		return customer.getCheckouts();
	}

	@Override
	@Transactional
	public void returnCheckout(int checkoutID) {
		LocalDateTime currentTime = LocalDateTime.parse(LocalDateTime.now().toString());
		String dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
				  .format(currentTime);
		Session session = sessionFactory.getCurrentSession();
		Query<Checkout> query = session.createQuery("from Checkout where id = :id", Checkout.class);
		query.setParameter("id", checkoutID);
		Checkout checkout = query.getSingleResult();
		Movie movie = checkout.getMovie();
		checkout.setReturnDate(dtf);
		movie.setAvailable(movie.getAvailable()+1);
		session.saveOrUpdate(movie);
		session.saveOrUpdate(checkout);
		
	}

	@Override
	@Transactional
	public void checkoutMovie(Movie movie, Customer customer) {
		LocalDateTime currentTime = LocalDateTime.parse(LocalDateTime.now().toString());
		String dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
				  .format(currentTime);
		Session session = sessionFactory.getCurrentSession();
		Checkout checkout = new Checkout(customer, movie, dtf, null);
		movie.setAvailable(movie.getAvailable()-1);
		session.saveOrUpdate(checkout);
	}

}
