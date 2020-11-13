package in.concept.booksdb.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String biography;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.LAZY)
	private List<Book> books;
	private String photograph;

	@JsonManagedReference
	public List<Book> getBooks() {
		return books;
	}

	public Author() {
		super();
	}

	public Author(int id, String name, String biography, List<Book> books, String photograph) {
		super();
		this.id = id;
		this.name = name;
		this.biography = biography;
		this.books = books;
		this.photograph = photograph;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getPhotograph() {
		return photograph;
	}

	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}

}