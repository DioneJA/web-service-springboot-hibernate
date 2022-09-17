package com.ifsuldemias.course.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ifsuldemias.course.entities.Category;
import com.ifsuldemias.course.entities.Order;
import com.ifsuldemias.course.entities.Product;
import com.ifsuldemias.course.entities.Users;
import com.ifsuldemias.course.entities.enums.OrderStatus;
import com.ifsuldemias.course.repositories.CategoryRepository;
import com.ifsuldemias.course.repositories.OrderRepository;
import com.ifsuldemias.course.repositories.ProductRepository;
import com.ifsuldemias.course.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	// Semeando o banco de dados
	@Override
	public void run(String... args) throws Exception {
		/*------------------------------- Category ------------------------------*/
		List<Category> category = new ArrayList<>();
		Category c1 = new Category(null, "Electronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");

		category.add(c1);
		category.add(c2);
		category.add(c3);

		categoryRepository.saveAll(category);
		/*------------------------------- Product ------------------------------*/
		List<Product> product = new ArrayList<>();
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		product.add(p1);
		product.add(p2);
		product.add(p3);
		product.add(p4);
		product.add(p5);

		productRepository.saveAll(product);
		
		/*Associando os produtos com suas categorias*/
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		/*------------------------------- Users ------------------------------*/
		List<Users> users = new ArrayList<>();
		Users u1 = new Users(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Users u2 = new Users(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		users.add(u1);
		users.add(u2);

		userRepository.saveAll(users);
		/*------------------------------- Orders ------------------------------*/
		List<Order> orders = new ArrayList<>();
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.DELIVERED);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u2, OrderStatus.CANCELED);
		orders.add(o1);
		orders.add(o2);
		orders.add(o3);

		orderRepository.saveAll(orders);
	}
}
