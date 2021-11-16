package com.samuel.microservice.ueb3library.mapper.classes;

import com.samuel.microservice.ueb3library.dao.model.BookDaoImpl;
import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.rest.BookPostRest;
import com.samuel.microservice.ueb3library.model.rest.BookRest;
import com.samuel.microservice.ueb3library.rest.BookRestImpl;
import com.samuel.microservice.ueb3library.mapper.interfaces.BookMapper;

public class BookMapperImpl implements BookMapper {
	@Override
	public BookRest mapToRest(final Book book) {
		return new BookRestImpl(book.getId(), book.getAuthor(),book.getTitle());
	}

	@Override
	public BookRest mapToRest(final BookPostRest bookPostRest){
		return new BookRestImpl(0, bookPostRest.getAuthor(), bookPostRest.getTitle());
	}

	@Override
	public Book mapToDao(final BookRest bookRest) {
		if(bookRest instanceof BookRestImpl bookRestWithId) {
			return new BookDaoImpl(bookRestWithId.getId(), bookRest.getAuthor(), bookRest.getTitle());
		}
		else{
			return new BookDaoImpl(0, bookRest.getAuthor(), bookRest.getTitle());
		}
	}
}
