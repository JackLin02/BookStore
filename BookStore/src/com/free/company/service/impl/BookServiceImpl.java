package com.free.company.service.impl;

import java.util.List;

import com.free.company.bean.Book;
import com.free.company.bean.Page;
import com.free.company.dao.BookDao;
import com.free.company.dao.impl.BookDaoImpl;
import com.free.company.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void delBookById(String id) {
		bookDao.delBookById(id);
	}

	@Override
	public Book getBookById(String id) {
		return bookDao.getBookById(id);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	public Page<Book> getBookByPage(String pageNo) {
		Page<Book> page = new Page<Book>();
		int pNo = 1;
		try {
			pNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
		}
		page.setPageNo(pNo);
		return bookDao.getBooksByPage(page);
	}

	@Override
	public Page<Book> getBookByPageAndPrice(String pageNo, String min, String max) {
		Page<Book> page = new Page<Book>();
		int pNo = 1;
		try {
			pNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
		}
		page.setPageNo(pNo);
		double minEnd = 0;
		double maxEnd = Double.MAX_VALUE;
		try {
			minEnd = Double.parseDouble(min);
			maxEnd = Double.parseDouble(max);
			double temp = 0;
			if(minEnd > maxEnd){
				temp = minEnd;
				minEnd = maxEnd;
				maxEnd = temp;
			}
		} catch (NumberFormatException e) {

		}
		return bookDao.getBooksByPageAndPrice(page, minEnd, maxEnd);
	}

}
