package in.concept.booksdb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.concept.booksdb.model.Review;
import in.concept.booksdb.repository.ReviewRepository;

@Service
public class ReviewService implements ReviewInterface {
	
	@Autowired
	private ReviewRepository rr;

	@Override
	public Review save(Review review) {
		return rr.save(review);
	}

	@Override
	public List<Review> getAllReviews() {
		return rr.findAll();
	}

	@Override
	public List<Review> findReviewById(String isbn) {
		return rr.getReviewByIsbn(isbn);
	}

	@Override
	public List<Review> getReviewInRange(int min, int max) {
		return rr.getReviewInRange(min, max);
	}

	@Override
	public List<Review> getReviewContainsText(String text) {
		return rr.getReviewContainsText(text);
	}

	@Override
	public int getAverageRating(String isbn) {
		return rr.getAverageRating(isbn);
	}

}
