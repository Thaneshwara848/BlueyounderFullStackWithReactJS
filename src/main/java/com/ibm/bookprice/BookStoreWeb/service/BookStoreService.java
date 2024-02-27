package com.ibm.bookprice.BookStoreWeb.service;

import java.util.List;
import java.util.Map;

import com.ibm.bookprice.BookStoreWeb.dto.Book;
import com.ibm.bookprice.BookStoreWeb.dto.BookInfo;
import com.ibm.bookprice.BookStoreWeb.rabbitmq.UserRatingInfo;

public interface BookStoreService {
	public List<Book> getMyBooks(String author, String category);

	public Book getBookByBookId(Integer bookId);

	public BookInfo getBookInfoByBookId(Integer bookId);

	public void placeOrder(Map<Integer, Book> mycartMap);

	public void addUserRating(UserRatingInfo userRating);

	public List<UserRatingInfo> getMyRatings(String userId);

	public List<String> getAuthorsList();

	public List<String> getCategoryList();

}
