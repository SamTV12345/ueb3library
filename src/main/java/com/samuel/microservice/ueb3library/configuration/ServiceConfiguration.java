package com.samuel.microservice.ueb3library.configuration;

import com.samuel.microservice.ueb3library.dao.impl.BookDaoJpaImpl;
import com.samuel.microservice.ueb3library.dao.impl.ReviewDaoJpaImpl;
import com.samuel.microservice.ueb3library.mapper.MapperFacade;
import com.samuel.microservice.ueb3library.service.BookService;
import com.samuel.microservice.ueb3library.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

	@Bean
	@Autowired
	public BookService bookService(final BookDaoJpaImpl bookDaoJpa, final MapperFacade mapperFacade){
		System.out.println(mapperFacade);
		return new BookService(bookDaoJpa,mapperFacade);
	}

	@Bean
	@Autowired
	public ReviewService reviewService(final ReviewDaoJpaImpl reviewDaoJpa, final MapperFacade mapperFacade,
	                                   final BookDaoJpaImpl bookDaoJpa){
		return new ReviewService(reviewDaoJpa, mapperFacade, bookDaoJpa);
	}
}
