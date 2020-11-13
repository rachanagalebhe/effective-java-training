package in.concept.booksdb.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import in.concept.booksdb.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	@Query(value = "SELECT * from review rw where rw.rating BETWEEN :min AND :max", nativeQuery = true)
	List<Review> getReviewInRange(int min, int max);

	@Query(value = "SELECT avg(rw.rating) as anyVariableName from review rw where rw.book_id LIKE %:isbn%", nativeQuery = true)
	int getAverageRating(String isbn);
	
	@Query(value = "SELECT * from review rw where rw.book_id LIKE %:isbn%", nativeQuery = true)
	List<Review> getReviewByIsbn(String isbn);

	@Query(value = "SELECT * from review rw where rw.review LIKE %?1%", nativeQuery = true)
	List<Review> getReviewContainsText(String text);

}