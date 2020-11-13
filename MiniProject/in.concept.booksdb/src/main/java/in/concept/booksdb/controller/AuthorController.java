package in.concept.booksdb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.concept.booksdb.model.Author;
import in.concept.booksdb.repository.AuthorRepository;
import in.concept.booksdb.services.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private AuthorService authorService;

//	/api/authors
//	Common for all Author related URL
	
//	GET
//	/
//	List of all authors
	
//	POST
//	/
//	Create an Author
	
//	GET
//	/{id}
//	Author by id
	
//	GET
//	/{id}/books
//	All books by current author
	
//	PUT
//	/{id}
//	Update Author
	
//	DELETE
//	/{id}
//	Delete author
	
	@PostMapping("/")
	public ResponseEntity<?> saveAuthor(@RequestBody Author author) {
		authorService.save(author);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/")
	public List<Object> listOfAuthors() {
		return authorService.authorDetails();
	}

	@GetMapping("/{id}")
	public Author authorDetails(@PathVariable("id") Integer id) {
		return authorService.getAuthor(id);
	}

	@DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable("id") int id) {
		authorService.deleteAuthor(id);
	}

	@GetMapping("/{id}/books")
	public Object BooksById(@PathVariable("id") int id) {
		return authorService.BooksById(id);
	}

	@PutMapping("/{id}")
	public void updateAuthor(@RequestBody Author author, @PathVariable("id") int id) {
		if (authorRepository.existsById(id)) {
			authorService.save(author);

		}
	}
}
