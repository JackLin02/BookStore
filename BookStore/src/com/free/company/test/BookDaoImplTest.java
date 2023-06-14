package com.free.company.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.free.company.bean.Book;
import com.free.company.bean.Page;
import com.free.company.dao.BookDao;
import com.free.company.dao.impl.BookDaoImpl;

public class BookDaoImplTest {

	BookDao bookDao = new BookDaoImpl();

	@Test
	public void testGetAllBooks() {
		List<Book> allBooks = bookDao.getAllBooks();
		for(Book book : allBooks){
			System.out.println(book);
		}
	}

	@Test
	public void testAddBook(){
		bookDao.addBook(new Book(null, "testTitle", "testAuthor", 100, 200, 250, null));
	}

	@Test
	public void testGetBooksByPage(){
		Page<Book> page = new Page<Book>();
		page.setPageNo(2);
		Page<Book> page2 = bookDao.getBooksByPage(page);

		System.out.println(page.getPageNo()+"/"+page.getTotalPageNo());
		System.out.println("総記録数： "+page.getTotalRecord());
		for(Book book : page2.getList()){
			System.out.println(book);
		}
	}

	@Test
	public void testBigDecimal(){
		BigDecimal bd = new BigDecimal("0.33");
		BigDecimal bd2 = new BigDecimal("0.33");

		double d = 0.33;
		double d2 = 0.33;

		BigDecimal rs = bd.multiply(bd2);

		System.out.println(rs.doubleValue());
	}

}
