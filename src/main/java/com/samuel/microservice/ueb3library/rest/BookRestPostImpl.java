package com.samuel.microservice.ueb3library.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samuel.microservice.ueb3library.model.rest.BookRest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class BookRestPostImpl implements BookRest {
	@JsonProperty("title")
	private String title;
	@JsonProperty("author")
	private String author;

}
