package com.free.company.service;

import com.free.company.bean.Cart;
import com.free.company.bean.User;

public interface OrderService {

	public String createOrder(Cart cart,User user);
}
