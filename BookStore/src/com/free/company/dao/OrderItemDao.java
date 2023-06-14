package com.free.company.dao;

import com.free.company.bean.OrderItem;

public interface OrderItemDao {

	void insertOrderItem(OrderItem orderItem);

	void insertOrderItem(Object[][] params);
}
