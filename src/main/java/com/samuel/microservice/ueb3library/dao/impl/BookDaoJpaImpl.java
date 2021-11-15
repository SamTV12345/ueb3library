package com.samuel.microservice.ueb3library.dao.impl;

import com.samuel.microservice.ueb3library.dao.model.BookDaoImpl;
import com.samuel.microservice.ueb3library.repositories.BookRepository;
import com.samuel.microservice.ueb3library.model.dao.Book;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BookDaoJpaImpl {
	private BookRepository bookRepository;

	public Book saveBook(final Book book){
		return bookRepository.save((BookDaoImpl) book);
	}

	public Optional<Book> findBookById(final int id){
		final Optional<BookDaoImpl> optional = bookRepository.findById(id);
		if(optional.isEmpty()){
			return Optional.empty();
		}
		else{
			return Optional.of(optional.get());
		}
	}

	public List<Book> findAllBooks() {
		return new ArrayList<>(bookRepository.findAll());
	}

	public void deleteBookById(final int id) {
		bookRepository.deleteById(id);
	}
}
