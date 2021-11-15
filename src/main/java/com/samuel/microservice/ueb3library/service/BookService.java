package com.samuel.microservice.ueb3library.service;

import com.samuel.microservice.ueb3library.dao.impl.BookDaoJpaImpl;
import com.samuel.microservice.ueb3library.mapper.MapperFacade;
import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.rest.BookRest;
import com.samuel.microservice.ueb3library.rest.BookRestImpl;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookService {
	private BookDaoJpaImpl bookDaoJpa;
	private MapperFacade mapperFacade;

	public BookRest saveBook(final BookRest bookRest){
		Book savedBook = bookDaoJpa.saveBook(mapperFacade.mapBookRestToDao(bookRest));
		return mapperFacade.mapBookToRest(savedBook);
	}

	public Optional<BookRestImpl> findBookById(final int id){
		final Optional<Book> optionalBook = bookDaoJpa.findBookById(id);
		if(optionalBook.isEmpty()){
			return Optional.empty();
		}
		return Optional.of((BookRestImpl) mapperFacade.mapBookToRest(optionalBook.get()));
	}

	public List<BookRest> findAllBooks() {
		final List<Book> daoBooks = bookDaoJpa.findAllBooks();

		return daoBooks.stream()
		               .map(mapperFacade::mapBookToRest)
		               .collect(Collectors.toList());
	}

	public void deleteBookById(final int id) {
		bookDaoJpa.deleteBookById(id);
	}
}
