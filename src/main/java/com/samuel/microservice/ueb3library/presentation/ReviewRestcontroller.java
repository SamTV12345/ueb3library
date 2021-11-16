package com.samuel.microservice.ueb3library.presentation;

import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.rest.BookRest;
import com.samuel.microservice.ueb3library.model.rest.ReviewRest;
import com.samuel.microservice.ueb3library.rest.BookRestImpl;
import com.samuel.microservice.ueb3library.rest.ReviewPostRestImpl;
import com.samuel.microservice.ueb3library.service.BookService;
import com.samuel.microservice.ueb3library.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/books/{id}/Reviews")
public class ReviewRestcontroller {
	private final ReviewService reviewService;
	private final BookService bookService;
	private final HttpServletRequest request;

	@GetMapping("")
	public ResponseEntity<List<ReviewRest>> getAllReviewsOfBook(@PathVariable(value = "id") int idToBeFound) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Optional<BookRestImpl> optionalBook = bookService.findBookById(idToBeFound);
			if(optionalBook.isPresent()) {
				return new ResponseEntity<>(reviewService.findAllReviewsByBook(optionalBook.get()), HttpStatus.OK);
			}
		}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("")
	public ResponseEntity<ReviewRest> postReview(@RequestBody ReviewPostRestImpl reviewPostRest){
		Optional<BookRestImpl> optionalBook = bookService.findBookById(reviewPostRest.getBookId());
		if(optionalBook.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(reviewService.saveReview(reviewPostRest, optionalBook.get()), HttpStatus.OK);
	}

	@GetMapping("/{reviewId}")
	public ResponseEntity<ReviewRest>  getReviewOfBook(@PathVariable(value = "id") int bookId, @PathVariable(value = "reviewId") int reviewId){
		Optional<BookRestImpl> optionalBook = bookService.findBookById(bookId);
		if(optionalBook.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else{
			Optional<ReviewRest> optionalFoundReview = reviewService.findReviewByBookAndId(optionalBook.get(), reviewId);
			if(optionalFoundReview.isEmpty()){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(optionalFoundReview.get(), HttpStatus.OK);
		}

	}


}

