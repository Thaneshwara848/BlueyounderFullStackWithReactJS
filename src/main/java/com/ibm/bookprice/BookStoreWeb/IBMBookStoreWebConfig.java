package com.ibm.bookprice.BookStoreWeb;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = { "com.ibm.BookStoreWeb" })
public class IBMBookStoreWebConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/MyJsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/mycss/**").addResourceLocations("classpath:/META-INF/resources/mycss/");
	}

	public static final String ORDER_QUEUE = "MyOrder-Queue";
	public static final String ORDER_EXCHANGE = "MyOrder-Exchange";
	public static final String USER_RATING_QUEUE = "MyUserRating-Queue";
	public static final String USER_RATING_EXCHANGE = "MyUserRating-Exchange";

	@Bean(name = "myOrderQueue")
	Queue createOrderQueue() {
		return QueueBuilder.durable(ORDER_QUEUE).build();
	}

	@Bean(name = "myOrderExchange")
	Exchange createOrderExchange() {
		return ExchangeBuilder.topicExchange(ORDER_EXCHANGE).build();
	}

	@Bean
	Binding orderBinding(Queue myOrderQueue, TopicExchange myOrderExchange) {
		return BindingBuilder.bind(myOrderQueue).to(myOrderExchange).with(ORDER_QUEUE);
	}

	@Bean(name = "myUserRatingQueue")
	Queue createUserRatingQueue() {
		return QueueBuilder.durable(USER_RATING_QUEUE).build();
	}

	@Bean(name = "myUserRatingExchange")
	Exchange createUserRatingExchange() {
		return ExchangeBuilder.topicExchange(USER_RATING_EXCHANGE).build();
	}

	@Bean
	Binding userRatingBinding(Queue myUserRatingQueue, TopicExchange myUserRatingExchange) {
		return BindingBuilder.bind(myUserRatingQueue).to(myUserRatingExchange).with(USER_RATING_QUEUE);
	}

}
