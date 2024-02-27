package com.ibm.bookprice.BookStoreWeb.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.bookprice.BookStoreWeb.rabbitmq.BookRatingInfo;
import com.ibm.bookprice.BookStoreWeb.rabbitmq.UserRatingInfo;

@FeignClient(value = "MyUserRatingMS", url = "http://localhost:6500")
public interface UserRatingProxy {
	@GetMapping("/userRatings/{userId}")
	public List<UserRatingInfo> getUserRatingByUserId(@PathVariable String userId);

	@GetMapping("/bookRatings/{bookId}")
	public BookRatingInfo getBookRatingByBookId(@PathVariable String bookId);
}
