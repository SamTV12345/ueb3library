package com.samuel.microservice.ueb3library.mapper.classes;

import com.samuel.microservice.ueb3library.mapper.interfaces.BookMapper;
import com.samuel.microservice.ueb3library.mapper.interfaces.ReviewMapper;
import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.rest.BookRest;
import com.samuel.microservice.ueb3library.model.rest.ReviewPostRest;
import com.samuel.microservice.ueb3library.model.rest.ReviewRest;
import com.samuel.microservice.ueb3library.rest.ReviewRestImpl;
import com.samuel.microservice.ueb3library.dao.model.ReviewDaoImpl;
import com.samuel.microservice.ueb3library.model.dao.Review;
import com.samuel.microservice.ueb3library.service.BookService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReviewMapperImpl implements ReviewMapper {

	@Override
	public ReviewRest mapToRest(final Review review) {
		return new ReviewRestImpl(
				review.getId(),
				review.getText(),
				review.getScore(),
				review.getBook().getId());
	}

	@Override
	public ReviewRest mapToRest(final ReviewPostRest reviewPostRest){
		return new ReviewRestImpl(0,
				reviewPostRest.getText(),
				reviewPostRest.getScore(),
				reviewPostRest.getBookId());
	}

	@Override
	public Review mapToDao(final ReviewRest reviewRest, final Book book) {
		if(reviewRest instanceof ReviewRestImpl reviewRestWithId) {
			return new ReviewDaoImpl(reviewRestWithId.getId(), reviewRest.getText(), reviewRest.getScore(),
					book);
		}
		else{
			return new ReviewDaoImpl(0, reviewRest.getText(), reviewRest.getScore(), book);
		}
	}
}
