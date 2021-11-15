package com.samuel.microservice.ueb3library.mapper;

import lombok.AllArgsConstructor;
import com.samuel.microservice.ueb3library.mapper.interfaces.BookMapper;
import com.samuel.microservice.ueb3library.mapper.interfaces.ReviewMapper;
import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.dao.Review;
import com.samuel.microservice.ueb3library.model.rest.BookRest;
import com.samuel.microservice.ueb3library.model.rest.ReviewRest;

@AllArgsConstructor
public class MapperFacade {
	private BookMapper bookMapper;
	private ReviewMapper reviewMapper;

	public Book mapBookRestToDao(final BookRest bookRest){
		return bookMapper.mapToDao(bookRest);
	}

	public BookRest mapBookToRest(final Book book){
		return bookMapper.mapToRest(book);
	}

	public Review mapReviewRestToDao(final ReviewRest reviewRest, final Book book){

		return reviewMapper.mapToDao(reviewRest, book);
	}

	public ReviewRest mapReviewToRest(final Review review){
		return reviewMapper.mapToRest(review);
	}
}
