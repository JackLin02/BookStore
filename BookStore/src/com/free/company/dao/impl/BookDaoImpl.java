package com.free.company.dao.impl;

import java.util.List;

import com.free.company.bean.Book;
import com.free.company.bean.Page;
import com.free.company.dao.BaseDao;
import com.free.company.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getAllBooks() {
		String sql = "SELECT id,title,author,price,sales,stock,img_path imgPath FROM books";
		return this.getBeanList(sql);
	}

	@Override
	public void addBook(Book book) {
		String sql = "INSERT INTO books(title,author,price,sales,stock,img_path) VALUES(?,?,?,?,?,?)";
		this.update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
	}

	@Override
	public void delBookById(String id) {
		String sql = "DELETE FROM books WHERE id = ?";
		this.update(sql, id);
	}

	@Override
	public Book getBookById(String id) {
		String sql = "SELECT id,title,author,price,sales,stock,img_path imgPath FROM books WHERE id = ?";
		return this.getBean(sql, id);
	}

	@Override
	public void updateBook(Book book) {
		String sql = "UPDATE books SET title = ?,author = ?,price = ?,sales = ?,stock = ?,img_path = ? WHERE id = ?";
		this.update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
	}

	@Override
	public void updateBook(int stock, int sales, int id) {
		String sql = "UPDATE books SET sales = ?,stock = ? WHERE id = ?";
		this.update(sql, sales,stock,id);
	}

	@Override
	public void updateBook(Object[][] params) {
		String sql = "UPDATE books SET sales = ?,stock = ? WHERE id = ?";
		this.batchUpdate(sql, params);
	}

	@Override
	public Page<Book> getBooksByPage(Page<Book> page) {
		String sql = "SELECT COUNT(*) FROM books";
		int count = Integer.parseInt(this.getSingleValue(sql)+"");
		page.setTotalRecord(count);
		String sql2 = "SELECT id,title,author,price,sales,stock,img_path imgPath "
				+ "FROM books "
				+ "WHERE 1 = 1 "
				+ "LIMIT ?,?";
		List<Book> list = this.getBeanList(sql2, (page.getPageNo()-1)*Page.PAGE_SIZE,Page.PAGE_SIZE);
		page.setList(list);
		return page;
	}

	@Override
	public Page<Book> getBooksByPageAndPrice(Page<Book> page, double min, double max) {
		String sql = "SELECT COUNT(*) "
				+ "FROM books "
				+ "WHERE 1=1 "
				+ "AND price BETWEEN ? AND ?";
		int count = Integer.parseInt(this.getSingleValue(sql, min,max)+"");
		page.setTotalRecord(count);
		String sql2 = "SELECT id,title,author,price,sales,stock,img_path imgPath "
				+ "FROM books "
				+ "WHERE 1=1 "
				+ "AND price BETWEEN ? AND ? "
				+ "LIMIT ?,?";
		List<Book> list = this.getBeanList(sql2, min,max,(page.getPageNo()-1)*Page.PAGE_SIZE,Page.PAGE_SIZE);
		page.setList(list);
		return page;
	}
}
