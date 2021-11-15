package com.samuel.microservice.ueb3library.repositories;

import com.samuel.microservice.ueb3library.dao.model.BookDaoImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDaoImpl,Integer> {
}
