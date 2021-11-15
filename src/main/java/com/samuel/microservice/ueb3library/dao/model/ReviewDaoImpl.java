package com.samuel.microservice.ueb3library.dao.model;

import com.samuel.microservice.ueb3library.model.dao.Book;
import lombok.*;
import com.samuel.microservice.ueb3library.model.dao.Review;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class ReviewDaoImpl implements Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NonNull
	private String text;
	@NonNull
	private String score;
	@NonNull
	@ManyToOne(targetEntity = BookDaoImpl.class)
	private Book book;
}
