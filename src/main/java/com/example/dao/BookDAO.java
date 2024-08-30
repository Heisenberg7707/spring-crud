package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.model.Book;

public class BookDAO {
	private JdbcTemplate jdbcTemplate;
	
	public BookDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Book> getAllBooks() {
	    String sql = "SELECT * FROM books";
	    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
	    List<Book> books = new ArrayList<>();

	    for (Map<String, Object> row : rows) {
	        Book book = new Book();
	        book.setId((Integer) row.get("id"));
	        book.setTitle((String) row.get("title"));
	        book.setAuthor((String) row.get("author"));
	        book.setPublishedYear((Integer) row.get("published_year"));
	        book.setIsbn((String) row.get("isbn"));
	        books.add(book);
	    }
	    return books;
	}

}
