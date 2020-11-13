package in.concept.booksdb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.concept.booksdb.model.Author;
import in.concept.booksdb.repository.AuthorRepository;

@Service
public class AuthorService implements AuthorInterface {

	@Autowired
	private AuthorRepository ar;

	@Override
	public void save(Author author) {
		ar.save(author);
	}

	@Override
	public List<Author> getAuthors() {
		return ar.findAll();
	}

	@Override
	public List<Object> authorDetails() {
		return ar.findAllAuthors();
	}

	@Override
	public void deleteAuthor(int id) {
		ar.deleteById(id);
	}

	@Override
	public Object BooksById(int id) {
		return ar.booksById(id);

	}

	@Override
	public Author getAuthor(Integer id) {
		return ar.authorById(id);
	}

}
