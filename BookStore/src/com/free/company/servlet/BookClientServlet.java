package com.free.company.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.free.company.bean.Book;
import com.free.company.bean.Page;
import com.free.company.service.BookService;
import com.free.company.service.impl.BookServiceImpl;

/**
 * BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();

	protected void getBooksByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo");
		Page<Book> page = bookService.getBookByPage(pageNo);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/client/book_client.jsp").forward(request, response);

	}

	protected void getBooksByPageAndPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo");
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		Page<Book> page = bookService.getBookByPageAndPrice(pageNo, min, max);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/client/book_client.jsp").forward(request, response);
	}

}
