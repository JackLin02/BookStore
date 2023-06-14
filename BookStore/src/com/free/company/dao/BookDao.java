package com.free.company.dao;

import java.util.List;

import com.free.company.bean.Book;
import com.free.company.bean.Page;

public interface BookDao {

	public List<Book> getAllBooks();

	public void addBook(Book book);

	public void delBookById(String id);

	public Book getBookById(String id);

	public void updateBook(Book book);

	public void updateBook(int stock,int sales,int id);

	public void updateBook(Object[][] params);

	public Page<Book> getBooksByPage(Page<Book> page);

	public Page<Book> getBooksByPageAndPrice(Page<Book> page,double min,double max);
}
