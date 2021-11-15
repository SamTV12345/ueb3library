package com.samuel.microservice.ueb3library.service;

import com.samuel.microservice.ueb3library.dao.impl.BookDaoJpaImpl;
import com.samuel.microservice.ueb3library.dao.impl.ReviewDaoJpaImpl;
import com.samuel.microservice.ueb3library.mapper.MapperFacade;
import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.dao.Review;
import com.samuel.microservice.ueb3library.model.rest.BookRest;
import com.samuel.microservice.ueb3library.model.rest.ReviewRest;
import com.samuel.microservice.ueb3library.rest.BookRestImpl;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ReviewService {
	private ReviewDaoJpaImpl reviewDaoJpa;
	private MapperFacade mapperFacade;
	private BookDaoJpaImpl bookDaoJpa;

	public ReviewRest saveReview(final ReviewRest reviewRest, final BookRest bookRest){
		Book book = mapperFacade.mapBookRestToDao(bookRest);
		final Review savedReview = reviewDaoJpa.saveReview(mapperFacade.mapReviewRestToDao(reviewRest, book));
		return mapperFacade.mapReviewToRest(savedReview);
	}

	public ReviewRest findReviewById(final int id){
		Optional<Review> optional =  reviewDaoJpa.findReview(id);
		if(optional.isEmpty()){
			throw new RuntimeException("Review nicht gefunden");
		}
		else{
			return mapperFacade.mapReviewToRest(optional.get());
		}
	}

	public List<ReviewRest> findAllReviewsByBook(final BookRestImpl book) {
		List<Review> listOfReviewsOfBook = reviewDaoJpa.findAllReviewsByBook(mapperFacade.mapBookRestToDao(book));
		return listOfReviewsOfBook.stream().map(mapperFacade::mapReviewToRest).collect(Collectors.toList());
	}
}
