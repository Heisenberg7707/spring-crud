package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.example.service.BookService;

@WebServlet("/books")
public class BookListServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private BookService bookService;
	
	public BookListServlet() {
		
	}

	@Override
	public void init() throws ServletException{
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("books", bookService.getAllBooks());
		request.getRequestDispatcher("WEB-INF/views/book-list.jsp").forward(request, response);
	}

}
