package in.concept.booksdb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.concept.booksdb.model.Book;
import in.concept.booksdb.repository.BookRepository;

@Service
public class BookService implements BookInterface {

	@Autowired
	private BookRepository br;

	@Override
	public void addBook(Book book) {
		br.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return br.findAll();
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return br.findById(isbn).orElse(null);
	}

	@Override
	public void removeBook(String isbn) {
		br.deleteById(isbn);
	}

	@Override
	public List<Book> getBooksByAuthor(String authorName) {
		return br.findByAuthorContainingIgnoreCase(authorName);
	}

	@Override
	public List<Book> getBooksInRatingRange(int min, int max) {
		return br.findbookByRating(min, max);
	}

	public void deleteBook(String isbn) {
		br.deleteById(isbn);
	}

	public List<Object> ReviewById(String isbn) {
		return br.reviewbyIsbn(isbn);
	}

	@Override
	public List<Book> getBooksInPriceRange(int min, int max) {
		return br.findbookByPrice(min, max);
	}

}
