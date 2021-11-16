package com.samuel.microservice.ueb3library.dao.impl;

import com.samuel.microservice.ueb3library.dao.model.ReviewDaoImpl;
import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.dao.Review;
import com.samuel.microservice.ueb3library.repositories.ReviewRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ReviewDaoJpaImpl {
	private ReviewRepository reviewRepository;


	public Review saveReview(final Review review){
		return reviewRepository.save((ReviewDaoImpl) review);
	}

	public Optional<Review> findReview(final int id){
		Optional<ReviewDaoImpl> optional =  reviewRepository.findById(id);
		if(optional.isEmpty()){
			return Optional.empty();
		}
		else{
			return Optional.of(optional.get());
		}
	}

	public List<Review> findAllReviewsByBook(final Book book) {
		return new ArrayList<>(reviewRepository.findAllByBook(book));
	}

	public Optional<Review> findReviewByBookAndReviewId(final Book book, final int id){

		Optional<ReviewDaoImpl> optionalReview = reviewRepository.findByBookAndId(book, id);

		if(optionalReview.isEmpty()){
			return Optional.empty();
		}
		return Optional.of(optionalReview.get());
	}
}
