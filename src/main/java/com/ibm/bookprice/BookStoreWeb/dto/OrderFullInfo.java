package com.ibm.bookprice.BookStoreWeb.dto;

import java.util.List;

import com.ibm.bookprice.BookStoreWeb.rabbitmq.OrderInfo;

public class OrderFullInfo {

	private Order order;
	private List<OrderItem> itemsList;

	public OrderFullInfo() {
	}

	public OrderFullInfo(Order order, List<OrderItem> itemsList) {
		super();
		this.order = order;
		this.itemsList = itemsList;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderItem> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<OrderItem> itemsList) {
		this.itemsList = itemsList;
	}

	
}
