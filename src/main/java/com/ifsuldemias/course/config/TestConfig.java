package com.ifsuldemias.course.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ifsuldemias.course.entities.Order;
import com.ifsuldemias.course.entities.Users;
import com.ifsuldemias.course.entities.enums.OrderStatus;
import com.ifsuldemias.course.repositories.OrderRepository;
import com.ifsuldemias.course.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	//Semeando o banco de dados
	@Override
	public void run(String... args) throws Exception {
		List<Users> users = new ArrayList<>();
		Users u1 = new Users(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Users u2 = new Users(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		users.add(u1);
		users.add(u2);
		
		userRepository.saveAll(users);
		
		List<Order> orders = new ArrayList<>();
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),u2, OrderStatus.DELIVERED);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),u2, OrderStatus.CANCELED); 
		orders.add(o1);
		orders.add(o2);
		orders.add(o3);
		
		orderRepository.saveAll(orders);
		
	}
}
