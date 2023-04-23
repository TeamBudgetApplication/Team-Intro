package edu.wccnet.hheck.final_project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="year")
	private int year;
	@Column(name="length")
	private int length;
	@Column(name="genre")
	private String genre;
	@Column(name="release_date")
	private String releaseDate;
	@Column(name="rating")
	private String rating;
	@Column(name="description")
	private String description;
	@Column(name="copies")
	private int copies;
	@Column(name="available")
	private int available;
	
	
	@JsonIgnore
	 
	@OneToMany(fetch = FetchType.EAGER,mappedBy="movie",targetEntity =
	Checkout.class, cascade=CascadeType.ALL) private List<Checkout> checkouts =
		new ArrayList<Checkout>();
	 
	public void add(Checkout checkout) { checkouts.add(checkout);
		checkout.setMovie(this); }
	 
	public void remove(Checkout checkout) { checkouts.remove(checkout); }
	 
	
	public Movie(String title, int year, int length, String genre, String releaseDate, String rating,
			String description, int copies, int available) {
		super();
		this.title = title;
		this.year = year;
		this.length = length;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.description = description;
		this.copies = copies;
		this.available = available;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", length=" + length + ", genre=" + genre + ", releaseDate="
				+ releaseDate + ", rating=" + rating + ", description=" + description + ", copies=" + copies
				+ ", available=" + available + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	
	public List<Checkout> getCheckouts() { return checkouts; }
	 
	public void setCheckouts(List<Checkout> checkouts) { this.checkouts =
			checkouts; }
	
	
}
