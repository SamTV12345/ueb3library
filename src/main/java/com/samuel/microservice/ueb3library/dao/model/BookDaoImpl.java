package com.samuel.microservice.ueb3library.dao.model;

import lombok.*;
import com.samuel.microservice.ueb3library.model.dao.Book;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class BookDaoImpl implements Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NonNull
	private String author;
	@NonNull
	private String title;
}
