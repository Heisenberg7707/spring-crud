package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.dao.BookDAO;
import com.example.service.BookService;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://db:3306/library");
		dataSource.setUsername("root");
		dataSource.setPassword("heisenberg7709");
		return dataSource;
	}
	
	@Bean
	public BookDAO bookDAO() {
		return new BookDAO(dataSource());
	}
	
	@Bean
	public BookService bookService() {
		return new BookService(bookDAO());
	}
}
