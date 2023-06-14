package com.free.company.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,CartItem> map = new LinkedHashMap<>();
	private int totalCount;
	private double totalAmount;

	public void addBookToCart(Book book){
		CartItem cartItem = map.get(book.getId()+"");
		if(cartItem == null){
			cartItem = new CartItem();
			cartItem.setBook(book);
			cartItem.setCount(1);
			map.put(book.getId()+"", cartItem);
		}else{
			int ncount = cartItem.getCount()+1;
			cartItem.setCount(ncount);
		}
	}

	public void delCartItem(String bookId){
		map.remove(bookId);
	}

	public void emptyCart(){
		map.clear();
	}

	public void updateCartItemCount(String bookId,String count){
		CartItem cartItem = map.get(bookId);
		try {
			cartItem.setCount(Integer.parseInt(count));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public List<CartItem> getCartItems(){
		return new ArrayList<>(map.values());
	}

	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public int getTotalCount() {
		int totalCount = 0;
		for(CartItem cartItem : getCartItems()){
			totalCount+=cartItem.getCount();
		}
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public double getTotalAmount() {
		BigDecimal tAmount = new BigDecimal("0");
		for(CartItem cartItem : getCartItems()){
			BigDecimal amount = new BigDecimal(cartItem.getAmount()+"");
			tAmount = tAmount.add(amount);
		}
		return tAmount.doubleValue();
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Cart(Map<String, CartItem> map, int totalCount, double totalAmount) {
		super();
		this.map = map;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
	}
	public Cart() {
		super();
	}
	@Override
	public String toString() {
		return "Cart [map=" + map + ", totalCount=" + totalCount + ", totalAmount=" + totalAmount + "]";
	}

}