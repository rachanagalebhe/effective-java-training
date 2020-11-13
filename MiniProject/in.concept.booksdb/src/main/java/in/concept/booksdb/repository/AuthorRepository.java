package in.concept.booksdb.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import in.concept.booksdb.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	@Query(value = "SELECT auth.name FROM author auth", nativeQuery = true)
	List<Object> findAllAuthors();


	@Query(value = "SELECT * from author auth where auth.id = :id", nativeQuery = true)
	Author authorById(Integer id);
	
	@Query(value = "select bk.isbn, bk.title from book bk where bk.author_id = :id", nativeQuery = true)
	List<Object> booksById(Integer id);


}
