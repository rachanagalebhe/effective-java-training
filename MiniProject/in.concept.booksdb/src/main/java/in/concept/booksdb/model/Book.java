package in.concept.booksdb.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "book")
public class Book {

	@Id
	private String isbn;
	private String title;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	private String description;
	private String tag;
	private String cover;
	private float price;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.LAZY)
	private List<Review> reviews;
	
	@JsonManagedReference
	public List<Review> getReviews() {
		return reviews;
	}

	@JsonBackReference
	public Author getAuthor() {
		return author;
	}

	public Book() {
		super();
	}

	public Book(String isbn, String title, Author author, String description, String tag, String cover, float price,
			List<Review> reviews) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.tag = tag;
		this.cover = cover;
		this.price = price;
		this.reviews = reviews;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}

