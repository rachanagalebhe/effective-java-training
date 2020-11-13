package in.concept.booksdb.services;

import java.util.List;
import in.concept.booksdb.model.Book;

public interface BookInterface {

	void addBook(Book book);

	List<Book> getAllBooks();

	Book getBookByIsbn(String isbn);

	void removeBook(String isbn);

	List<Book> getBooksByAuthor(String authorName);

	List<Book> getBooksInPriceRange(int min, int max);

	List<Book> getBooksInRatingRange(int min, int max);

}

