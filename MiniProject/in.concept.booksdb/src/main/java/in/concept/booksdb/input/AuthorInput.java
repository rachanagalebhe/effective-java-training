package in.concept.booksdb.input;

import in.concept.booksdb.model.Author;

public class AuthorInput {
	
	private Author author;
	
	public AuthorInput() {
		super();
	}

	public AuthorInput(Author author) {
		super();
		this.author = author;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
