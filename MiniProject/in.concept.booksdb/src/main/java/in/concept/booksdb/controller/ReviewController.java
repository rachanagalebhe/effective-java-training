package in.concept.booksdb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import in.concept.booksdb.model.Review;
import in.concept.booksdb.services.ReviewService;

@RestController
@RequestMapping("/api/review")
@CrossOrigin
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
//	/api/reviews 
//	Base url for all review routes
//
//	GET 
//	/
//	Get all reviews
//
//	POST
//	/{isbn} 
//	ADD NEW REVIEW FOR GIVEN BOOK
//
//	GET 
//	/{isbn}
//	Get all reviews for given isbn
//
//	GET 
//	/ratingbetween/{min}/and/{max}
//	Get All reviews in min-max range
//
//	GET
//	/{isbn}/average-rating 
//	Return the average rating
//
//	GET 
//	/containing/{text} 
//	Get all reviews containing text

	@PostMapping("/")
	public void addReview(@RequestBody Review review) {
		reviewService.save(review);
	}

	@GetMapping("/")
	public List<Review> getAllReviews() {
		return reviewService.getAllReviews();
	}

	@RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
	public List<Review> getReviewById(@PathVariable String isbn) {
		return reviewService.findReviewById(isbn);
	}

	@GetMapping("/rating-between/{min}/and/{max}")
	public List<Review> getReviewInRange(@PathVariable("min") int min, @PathVariable("max") int max) {
		return reviewService.getReviewInRange(min, max);
	}

	@GetMapping("/containing/{text}")
	public List<Review> getReviewContainsText(@PathVariable("text") String text) {
		return reviewService.getReviewContainsText(text);
	}

	@GetMapping("/{isbn}/average-rating")
	public int getAverageRating(@PathVariable("isbn") String isbn) {
		return reviewService.getAverageRating(isbn);
	}
}

