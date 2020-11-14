package in.concept.booksdb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.concept.booksdb.model.Book;
import in.concept.booksdb.repository.AuthorRepository;
import in.concept.booksdb.repository.BookRepository;
import in.concept.booksdb.services.BookService;

@RestController()
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;

//	/api/books
//	Common route for all book related URL
	
//	GET
//	/
//	List all books
	
//	POST
//	/
//	Create new book

//	POST 
//	/  
//	Create new book
	
//	GET
//	/{isbn} 
//	Book by isbn
	
//	PUT 
//	/{isbn}
//	Update book
	
//	DELETE
//	/{isbn} 
//	Delete book
	
//	GET 
//	/by/{author-name}
//	Get book by matching author name part
	
//	GET 
//	/price/between/{min}/and/{max}
//	Get book in price range
	
//	GET 
//	/{isbn}/reviews 
//	Get all reviews for the given isbn
	
	@PostMapping(value = "/", consumes = "application/json")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

	@GetMapping("/")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/{isbn}")
	public Book getBookById(@PathVariable("isbn") String isbn) {
		return bookService.getBookByIsbn(isbn);
	}

	@GetMapping("/by/{author_name}")
	public List<Book> getBooksByAuthor(@PathVariable("author_name") String author_name) {
		return bookService.getBooksByAuthor(author_name);
	}

	@DeleteMapping("/{isbn}")
	public void deleteBook(@PathVariable("isbn") String isbn) {
		bookService.deleteBook(isbn);
	}

	@PutMapping("/{isbn}")
	public void updateAuthor(@RequestBody Book book, @PathVariable("isbn") String isbn) {
		if (bookRepository.existsById(isbn)) {
			bookService.addBook(book);
		}
	}

	@GetMapping("/{isbn}/reviews")
	public List<Object> ReviewsByIsbn(@PathVariable("isbn") String isbn) {
		return bookService.ReviewById(isbn);
	}

	@GetMapping("/price/between/{min}/and/{max}")
	public List<Book> getBooksByPrice(@PathVariable("min") int min, @PathVariable("max") int max) {
		return bookService.getBooksInPriceRange(min, max);
	}

}
