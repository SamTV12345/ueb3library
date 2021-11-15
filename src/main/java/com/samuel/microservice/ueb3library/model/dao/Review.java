package com.samuel.microservice.ueb3library.model.dao;

public interface Review {

	String getText();

	String getScore();

	int getId();

	Book getBook();
}
