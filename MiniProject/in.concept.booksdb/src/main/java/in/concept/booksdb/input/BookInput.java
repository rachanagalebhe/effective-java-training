package in.concept.booksdb.input;

import in.concept.booksdb.model.Book;

public class BookInput {
	
	private Book book;

	public BookInput() {
		super();
	}

	public BookInput(Book book) {
		super();
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	

}
