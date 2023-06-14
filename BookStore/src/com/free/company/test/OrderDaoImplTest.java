package com.free.company.test;

import java.util.Date;

import org.junit.Test;

import com.free.company.bean.Order;
import com.free.company.bean.OrderItem;
import com.free.company.dao.OrderDao;
import com.free.company.dao.OrderItemDao;
import com.free.company.dao.impl.OrderDaoImpl;
import com.free.company.dao.impl.OrderItemDaoImpl;

public class OrderDaoImplTest {

	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao oid = new OrderItemDaoImpl();
	@Test
	public void testInsertOrder() {
		orderDao.insertOrder(new Order("test01", new Date(), 2, 300, 0, 1));
	}

	@Test
	public void testInsertOrderItem() {
		oid.insertOrderItem(new OrderItem(null, 1, 150, "testt", "testa", 150, "testt", "test001"));
	}

}
