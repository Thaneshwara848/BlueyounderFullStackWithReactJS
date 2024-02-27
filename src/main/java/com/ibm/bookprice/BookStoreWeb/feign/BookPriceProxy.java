package com.ibm.bookprice.BookStoreWeb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.bookprice.BookStoreWeb.dto.Book;

@FeignClient(value = "MyBookPriceMS", url = "http://localhost:9000")
public interface BookPriceProxy {
	@GetMapping("/bookPrice/{bookId}")
	public Book getBookPrice(@PathVariable Integer bookId);

	@GetMapping("/offeredPrice/{bookId}")
	public double getOfferedPrice(@PathVariable Integer bookId);
}
