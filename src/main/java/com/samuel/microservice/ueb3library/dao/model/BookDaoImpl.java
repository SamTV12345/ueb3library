package com.samuel.microservice.ueb3library.dao.model;

import lombok.*;
import com.samuel.microservice.ueb3library.model.dao.Book;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class BookDaoImpl implements Book {
	@Min(0)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	@NonNull
	private String author;
	@NotBlank
	@NonNull
	private String title;
}
