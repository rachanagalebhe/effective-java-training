package in.concept.booksdb.services;

import java.util.List;
import in.concept.booksdb.model.Review;

public interface ReviewInterface {

	Review save(Review review);

	List<Review> getAllReviews();

	List<Review> findReviewById(String isbn);

	List<Review> getReviewInRange(int min, int max);

	List<Review> getReviewContainsText(String text);

	int getAverageRating(String isbn);

}
