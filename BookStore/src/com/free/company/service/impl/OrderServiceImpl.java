package com.free.company.service.impl;

import java.util.Date;
import java.util.List;

import com.free.company.bean.Book;
import com.free.company.bean.Cart;
import com.free.company.bean.CartItem;
import com.free.company.bean.Order;
import com.free.company.bean.OrderItem;
import com.free.company.bean.User;
import com.free.company.dao.BookDao;
import com.free.company.dao.OrderDao;
import com.free.company.dao.OrderItemDao;
import com.free.company.dao.impl.BookDaoImpl;
import com.free.company.dao.impl.OrderDaoImpl;
import com.free.company.dao.impl.OrderItemDaoImpl;
import com.free.company.service.OrderService;
import com.free.company.util.JDBCUtils;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	private BookDao bookDao = new BookDaoImpl();

	@Override
	public String createOrder(Cart cart, User user) {
		String orderId = System.currentTimeMillis()+""+user.getId();
		orderDao.insertOrder(new Order(orderId, new Date(), cart.getTotalCount(), cart.getTotalAmount(), 0, user.getId()));
		List<CartItem> cartItems = cart.getCartItems();
		Object[][] orderItemParams = new Object[cartItems.size()][];
		Object[][] bookParams = new Object[cartItems.size()][];
		for(int i=0;i<cartItems.size();i++){
			CartItem cartItem = cartItems.get(i);
			Book book = cartItem.getBook();
			int count = cartItem.getCount();
			orderItemParams[i] = new Object[] {count,
					cartItem.getAmount(), book.getTitle(), book.getAuthor(),
					book.getPrice(), book.getImgPath(), orderId};
			int stock = book.getStock()-count;
			int sales = book.getSales()+count;
			bookParams[i] = new Object[] {sales, stock, book.getId()};
		}

		orderItemDao.insertOrderItem(orderItemParams);
		bookDao.updateBook(bookParams);

		cart.emptyCart();
		return orderId;
	}

}
