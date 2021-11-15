package com.samuel.microservice.ueb3library.mapper.interfaces;

import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.rest.ReviewRest;
import com.samuel.microservice.ueb3library.model.dao.Review;

public interface ReviewMapper{

	ReviewRest mapToRest(Review review);
	Review mapToDao(ReviewRest reviewRest, Book book);
}
