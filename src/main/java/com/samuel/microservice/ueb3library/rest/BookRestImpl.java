package com.samuel.microservice.ueb3library.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samuel.microservice.ueb3library.model.dao.Book;
import lombok.*;
import com.samuel.microservice.ueb3library.model.rest.BookRest;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRestImpl implements BookRest {
	@JsonProperty("id")
	private int id;
	@JsonProperty("author")
	private String author;

	@JsonProperty("title")
	private String title;
}
