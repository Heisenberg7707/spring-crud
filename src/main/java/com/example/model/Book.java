package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

	public Book(){}

	public Book(String title, String author, int publishedYear){
		this.title = title;
		this.author = author;
		this.publishedYear = publishedYear;
	}

	private int id;
	private String title;
	private String author;
	private int publishedYear;
}
