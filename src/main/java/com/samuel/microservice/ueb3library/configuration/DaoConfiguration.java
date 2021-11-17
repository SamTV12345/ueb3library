package com.samuel.microservice.ueb3library.configuration;

import com.samuel.microservice.ueb3library.dao.impl.BookDaoJpaImpl;
import com.samuel.microservice.ueb3library.dao.impl.ReviewDaoJpaImpl;
import com.samuel.microservice.ueb3library.dao.model.BookDaoImpl;
import com.samuel.microservice.ueb3library.dao.model.ReviewDaoImpl;
import com.samuel.microservice.ueb3library.repositories.BookRepository;
import com.samuel.microservice.ueb3library.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ReviewRepository reviewRepository;

	@Bean
	public BookDaoJpaImpl bookDaoJpa(){
		System.out.println("Das ist die neue Version mit Docker");
		return new BookDaoJpaImpl(bookRepository);
	}

	@Bean
	public ReviewDaoJpaImpl reviewDao(){
		return new ReviewDaoJpaImpl(reviewRepository);
	}
}
