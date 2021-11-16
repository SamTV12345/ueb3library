package com.samuel.microservice.ueb3library.mapper.interfaces;

import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.rest.BookPostRest;
import com.samuel.microservice.ueb3library.model.rest.BookRest;

public interface BookMapper {

	BookRest mapToRest(Book book);

	BookRest mapToRest(BookPostRest bookPostRest);

	Book mapToDao(BookRest bookRest);
}
