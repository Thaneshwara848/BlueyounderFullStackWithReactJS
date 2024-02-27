package com.ibm.bookprice.BookStoreWeb.rabbitmq;

import java.io.Serializable;
import java.util.List;

public class OrderFullInfo implements Serializable {
	private OrderInfo order;
	private List<OrderItemInfo> itemsList;

	public OrderFullInfo(OrderInfo order, List<OrderItemInfo> itemsList) {
		super();
		this.order = order;
		this.itemsList = itemsList;
	}

	public OrderFullInfo() {
		super();
	}

	public OrderInfo getOrder() {
		return order;
	}

	public void setOrder(OrderInfo order) {
		this.order = order;
	}

	public List<OrderItemInfo> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<OrderItemInfo> itemsList) {
		this.itemsList = itemsList;
	}

	@Override
	public String toString() {
		return "OrderFullInfo [order=" + order + ", itemsList=" + itemsList + "]";
	}

//Constructors
//Setters and Getters
}
