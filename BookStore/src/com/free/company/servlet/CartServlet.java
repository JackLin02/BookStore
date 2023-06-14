package com.free.company.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.free.company.bean.Book;
import com.free.company.bean.Cart;
import com.free.company.bean.CartItem;
import com.free.company.service.BookService;
import com.free.company.service.impl.BookServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();

	protected void addBookToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String bookId = request.getParameter("bookId");
		Book book = bookService.getBookById(bookId);
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addBookToCart(book);
		Integer stock = book.getStock();
		int count = cart.getMap().get(book.getId()+"").getCount();
		if(count > stock){
			session.setAttribute("msg", "在庫不足，在庫中に"+stock+"件商品があります");
			cart.getMap().get(book.getId()+"").setCount(stock);
		}else{
			session.setAttribute("title", book.getTitle());
		}
		String url = request.getHeader("Referer");
		response.sendRedirect(url);
	}

	protected void delCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String bookId = request.getParameter("bookId");
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null){
			cart.delCartItem(bookId);
		}
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}

	protected void emptyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null){
			cart.emptyCart();
		}
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}

	protected void updateCartItemCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String bookId = request.getParameter("bookId");
		String count = request.getParameter("count");
		System.out.println("bookId:"+bookId);
		System.out.println("count:"+count);
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null){
			cart.updateCartItemCount(bookId, count);
		}
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}

}
