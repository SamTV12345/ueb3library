package com.samuel.microservice.ueb3library.presentation;

import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.rest.BookRest;
import com.samuel.microservice.ueb3library.rest.BookRestImpl;
import com.samuel.microservice.ueb3library.rest.BookRestPostImpl;
import com.samuel.microservice.ueb3library.service.BookService;
import com.samuel.microservice.ueb3library.service.ReviewService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/books")
public class BookRestcontroller {
	private final BookService bookService;
	private final HttpServletRequest request;

	@GetMapping("")
	public ResponseEntity<List<BookRest>> getAllBooks(){
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookRest> getBook(@PathVariable(value = "id") int idToBeFound){
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Optional<BookRestImpl> optionalBook = bookService.findBookById(idToBeFound);

			if (optionalBook.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
			}
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("")
	public ResponseEntity<BookRest>  postBook(@RequestBody BookRestPostImpl bookRestPost){
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<>(bookService.saveBook(bookRestPost), HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") int bookId){
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Optional<BookRestImpl> optionalBook = bookService.findBookById(bookId);
			if (optionalBook.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				bookService.deleteBookById(optionalBook.get().getId());
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
