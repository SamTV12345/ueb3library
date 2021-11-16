package com.samuel.microservice.ueb3library.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samuel.microservice.ueb3library.model.rest.ReviewPostRest;
import com.samuel.microservice.ueb3library.model.rest.ReviewRest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReviewPostRestImpl implements ReviewPostRest {
	@JsonProperty("text")
	private String text;
	@JsonProperty("score")
	private String score;
	@JsonProperty("bookId")
	private int bookId;
}
