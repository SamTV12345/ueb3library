package com.samuel.microservice.ueb3library.dao.model;

import com.samuel.microservice.ueb3library.model.dao.Book;
import lombok.*;
import com.samuel.microservice.ueb3library.model.dao.Review;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "review")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class ReviewDaoImpl implements Review {
	@Min(0)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	@NonNull
	private String text;
	@Min(1)
	@Max(5)
	@NonNull
	private int score;
	@NotBlank
	@NonNull
	@ManyToOne(targetEntity = BookDaoImpl.class)
	private Book book;
}
