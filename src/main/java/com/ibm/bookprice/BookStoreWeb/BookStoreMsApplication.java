package com.ibm.bookprice.BookStoreWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookStoreMsApplication  implements CommandLineRunner{
	static Logger log=LoggerFactory.getLogger(BookStoreMsApplication.class);

	public static void main(String[] args) {
		log.info(" BookStoreMS - Begin ");
		SpringApplication.run(BookStoreMsApplication.class, args);
		log.info(" BookStoreMS - Ends ");
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info(" BookStoreeMS - Launched.... ");
	}

}
