package in.concept.booksdb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "review")
public class Review {

	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	private String reviewer;
	private String review;
	@Min(1)
	@Max(5)
	private int rating;

	@JsonBackReference
	public Book getBook() {
		return book;
	}
	
	public Review() {
		super();
	}
 
	public Review(int id, String reviewer, String review, Book book,@Min(1) @Max(5) int rating) {
		super();
		this.id = id;
		this.reviewer = reviewer;
		this.review = review;
		this.book = book;
		this.rating = rating;
	}
-+*
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


}

