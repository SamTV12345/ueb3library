package com.samuel.microservice.ueb3library.mapper.interfaces;

import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.rest.BookRest;

public interface BookMapper {

	BookRest mapToRest(Book book);

	Book mapToDao(BookRest bookRest);
}
