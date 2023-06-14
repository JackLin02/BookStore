package com.free.company.service;

import java.util.List;

import com.free.company.bean.Book;
import com.free.company.bean.Page;

public interface BookService {

	public List<Book> getAllBooks();

	public void addBook(Book book);

	public void delBookById(String id);

	public Book getBookById(String id);

	public void updateBook(Book book);

	public Page<Book> getBookByPage(String pageNo);

	public Page<Book> getBookByPageAndPrice(String pageNo,String min,String max);
}
