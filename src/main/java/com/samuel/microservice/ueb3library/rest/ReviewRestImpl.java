package com.samuel.microservice.ueb3library.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.samuel.microservice.ueb3library.model.rest.ReviewRest;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRestImpl implements ReviewRest {
	@JsonProperty("id")
	private int id;
	@JsonProperty("text")
	private String text;
	@JsonProperty("score")
	private String score;
	@JsonProperty("bookId")
	private int bookId;

}
