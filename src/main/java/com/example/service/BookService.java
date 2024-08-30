package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.BookDAO;
import com.example.model.Book;

public class BookService {
	private final BookDAO bookDAO;
	
	@Autowired
	public BookService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public List<Book> getAllBooks(){
		return bookDAO.getAllBooks();
	}

}
