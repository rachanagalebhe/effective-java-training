package in.concept.booksdb.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import in.concept.booksdb.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	@Query(value = "SELECT rw.review from review rw where rw.book_id = :isbn", nativeQuery = true)
	List<Object> reviewbyIsbn(String isbn);
	
	@Query(value = "select * from book bk where " + "exists(select 1 from author auth where auth.id = bk.author_id and auth.name = :authorNamePart)", nativeQuery = true)
	List<Book> findByAuthorContainingIgnoreCase(String authorNamePart);

	@Query(value = "SELECT * from book bk where bk.price BETWEEN :min AND :max", nativeQuery = true)
	List<Book> findbookByPrice(int min, int max);

}
