package com.free.company.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.free.company.bean.Book;
import com.free.company.bean.Page;
import com.free.company.service.BookService;
import com.free.company.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();

	protected void getBooksByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo");
		Page<Book> page = bookService.getBookByPage(pageNo);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

	protected void delBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		bookService.delBookById(bookId);
		response.sendRedirect(request.getContextPath()+"/BookServlet?method=getAllBooks");
	}

	protected void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bookId");
		Book book = bookService.getBookById(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/pages/manager/book_update.jsp").forward(request, response);
	}

	protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		bookService.addBook(new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null));
		response.sendRedirect(request.getContextPath()+"/BookServlet?method=getAllBooks");
	}

	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bookId");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		if(id == null || "".equals(id)){
			bookService.addBook(new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null));
		}else{
			bookService.updateBook(new Book(Integer.parseInt(id), title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null));
		}
		response.sendRedirect(request.getContextPath()+"/BookServlet?method=getAllBooks");
	}
}
