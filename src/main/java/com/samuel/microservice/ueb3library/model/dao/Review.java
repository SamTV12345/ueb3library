package com.samuel.microservice.ueb3library.model.dao;

public interface Review {

	String getText();

	int getScore();

	int getId();

	Book getBook();
}
