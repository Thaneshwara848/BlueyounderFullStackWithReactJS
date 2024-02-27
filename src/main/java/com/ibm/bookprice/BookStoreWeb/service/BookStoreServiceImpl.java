package com.ibm.bookprice.BookStoreWeb.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bookprice.BookStoreWeb.IBMBookStoreWebConfig;
import com.ibm.bookprice.BookStoreWeb.dto.Book;
import com.ibm.bookprice.BookStoreWeb.dto.BookInfo;
//import com.ibm.bookprice.BookStoreWeb.dto.OrderFullInfo;
import com.ibm.bookprice.BookStoreWeb.feign.BookPriceProxy;
import com.ibm.bookprice.BookStoreWeb.feign.BookSearchProxy;
import com.ibm.bookprice.BookStoreWeb.feign.PlaceOrderProxy;
import com.ibm.bookprice.BookStoreWeb.feign.UserRatingProxy;
import com.ibm.bookprice.BookStoreWeb.rabbitmq.OrderFullInfo;
import com.ibm.bookprice.BookStoreWeb.rabbitmq.OrderInfo;
import com.ibm.bookprice.BookStoreWeb.rabbitmq.OrderItemInfo;
import com.ibm.bookprice.BookStoreWeb.rabbitmq.UserRatingInfo;

@Service
public class BookStoreServiceImpl implements BookStoreService {

	static Logger log = LoggerFactory.getLogger(BookStoreServiceImpl.class);
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	BookPriceProxy bookPriceProxy;
	@Autowired
	BookSearchProxy bookSearchProxy;
	@Autowired
	PlaceOrderProxy placeOrderProxy;
	@Autowired
	UserRatingProxy userRatingProxy;

	Map<Integer, Book> booksMap = new LinkedHashMap<>();

	public List<String> getAuthorsList() { // 1
		List<String> authorsList = new ArrayList<>();
		authorsList.add("All Authors");
		authorsList.add("Suresh");
		authorsList.add("Vas");
		authorsList.add("Sri");
		return authorsList;
	}

	public List<String> getCategoryList() { // 2
		List<String> catList = new ArrayList<>();
		catList.add("All Categories");
		catList.add("Web");
		catList.add("Spring");
		return catList;
	}

	public List<Book> getMyBooks(String author, String category) {// 3
		System.out.println("BookStoreServiceImpl - getBooks()");
		if (author == null || author.length() == 0) {
			author = "All Authors";
		}
		if (category == null || category.length() == 0) {
			category = "All Categories";
		}
		// Invoke BookSearchMS using Feign

		List<Book> bookList = bookSearchProxy.getBooks(author, category);
		for (Book mybook : bookList) {
			booksMap.put(mybook.getBookId(), mybook);
		}
		return bookList;
	}

	public BookInfo getBookInfoByBookId(Integer bookId) {
		System.out.println("BookStoreServiceImpl - getBookInfoByBookId()");
		// Invoke BookSearchMS using Feign
		BookInfo bookInfo = bookSearchProxy.getBookById(bookId);
		return bookInfo;
	}

	public Book getBookByBookId(Integer bookId) {
		System.out.println("BookStoreServiceImpl - getBookByBookId()");
		System.out.println(bookId);
		Book mybook = booksMap.get(bookId);
		return mybook;
	}

	public void placeOrder(Map<Integer, Book> mycartMap) {
		System.out.println("---2.BookStoreServiceImpl--placeOrder()----");
		List<OrderItemInfo> itemList = new ArrayList<>();
		double totalPrice = 0.0;
		int totalQuantity = 0;
		for (Book mybook : mycartMap.values()) {
			Integer bookId = mybook.getBookId();
			// Invoke BookPrice Controller using Feign
			double offerPrice = bookPriceProxy.getOfferedPrice(bookId);
			OrderItemInfo item = new OrderItemInfo(0, bookId, 1, 1,offerPrice);
			itemList.add(item);
			totalPrice = totalPrice + offerPrice;
			totalQuantity = totalQuantity + 1;
		}
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		String orderDate = formatter.format(today);
		System.out.println(orderDate);
		OrderInfo orderInfo = new OrderInfo(1,orderDate, "U-111", totalQuantity, totalPrice, "New");
		OrderFullInfo orderFullInfo = new OrderFullInfo();
		orderFullInfo.setOrder(orderInfo);
		orderFullInfo.setItemsList(itemList);
		// Sending Order Message to RabbitMQ
		rabbitTemplate.convertAndSend(IBMBookStoreWebConfig.ORDER_QUEUE, orderFullInfo);
		System.out.println("Order Placed");
	}

	public void addUserRating(UserRatingInfo userRating) {
		System.out.println("---2.BookStoreServiceImpl--addUserRating()----");
		// Sending UserRating Message RabbitMQ
		UserRatingInfo userRatingInfo = new UserRatingInfo(userRating.getUserId(), userRating.getBookId(),userRating.getRating(), userRating.getReview());
		rabbitTemplate.convertAndSend(IBMBookStoreWebConfig.USER_RATING_QUEUE, userRatingInfo);
		System.out.println("Rating Added");
	}

	public List<UserRatingInfo> getMyRatings(String userId) {
		// Invoke UserRating MS using Feign
		List<UserRatingInfo> ratingsList = userRatingProxy.getUserRatingByUserId(userId);
		return ratingsList;
	}

}
