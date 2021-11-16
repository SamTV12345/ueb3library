package com.samuel.microservice.ueb3library.repositories;

import com.samuel.microservice.ueb3library.dao.model.ReviewDaoImpl;
import com.samuel.microservice.ueb3library.model.dao.Book;
import com.samuel.microservice.ueb3library.model.dao.Review;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ReviewDaoImpl, Integer> {
	List<ReviewDaoImpl> findAllByBook(final Book book);

	Optional<ReviewDaoImpl> findByBookAndId(@NonNull Book book, int id);
}
