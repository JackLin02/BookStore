package com.free.company.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.free.company.bean.Cart;
import com.free.company.bean.User;
import com.free.company.service.OrderService;
import com.free.company.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();

	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		String orderId = orderService.createOrder(cart, user);
		session.setAttribute("orderId", orderId);
		response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
	}

}
