package com.samuel.microservice.ueb3library.configuration;

import com.samuel.microservice.ueb3library.mapper.MapperFacade;
import com.samuel.microservice.ueb3library.mapper.classes.BookMapperImpl;
import com.samuel.microservice.ueb3library.mapper.classes.ReviewMapperImpl;
import com.samuel.microservice.ueb3library.mapper.interfaces.BookMapper;
import com.samuel.microservice.ueb3library.mapper.interfaces.ReviewMapper;
import com.samuel.microservice.ueb3library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

	@Bean
	public BookMapper bookMapper(){
		return new BookMapperImpl();
	}

	@Bean
	public ReviewMapper reviewMapper(){
		return new ReviewMapperImpl();
	}

	@Bean
	@Autowired
	public MapperFacade mapperFacade(final ReviewMapper reviewMapper, final BookMapper bookMapper){
		return new MapperFacade(bookMapper, reviewMapper);
	}
}
