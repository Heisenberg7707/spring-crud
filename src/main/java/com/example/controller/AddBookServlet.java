package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.example.model.Book;
import com.example.service.BookService;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet{

    @Autowired
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int publishedYear = Integer.parseInt(request.getParameter("publishedYear"));

        Book newBook = new Book(title, author, publishedYear);

        bookService.addBook(newBook);

        response.sendRedirect(request.getContextPath() + "/books");
    }


}
