package com.free.company.dao.impl;

import com.free.company.bean.Order;
import com.free.company.dao.BaseDao;
import com.free.company.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public void insertOrder(Order order) {
		String sql = "INSERT INTO orders(id,order_time,total_count,total_amount,state,user_id) VALUES(?,?,?,?,?,?)";
		this.update(sql, order.getId(),order.getOrderTime(),order.getTotalCount(),order.getTotalAmount(),order.getState(),order.getUserId());
	}

}
