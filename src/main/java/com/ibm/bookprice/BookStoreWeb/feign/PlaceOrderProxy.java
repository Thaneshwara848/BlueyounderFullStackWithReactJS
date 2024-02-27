package com.ibm.bookprice.BookStoreWeb.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.bookprice.BookStoreWeb.dto.OrderInfo;





@FeignClient( url = "http://localhost:7000")//if url is there value will not be considered
public interface PlaceOrderProxy {
	@GetMapping("/myorders/{userId}")
	public List<OrderInfo> getOrdersByUserId(@PathVariable String userId);

	@GetMapping("/myorder/{orderId}")
	public OrderInfo getOrdersByUserId(@PathVariable Integer orderId);
}
