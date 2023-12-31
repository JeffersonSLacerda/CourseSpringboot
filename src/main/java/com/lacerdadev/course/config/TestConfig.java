package com.lacerdadev.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lacerdadev.course.entities.Category;
import com.lacerdadev.course.entities.Order;
import com.lacerdadev.course.entities.Product;
import com.lacerdadev.course.entities.User;
import com.lacerdadev.course.entities.enums.OrderStatus;
import com.lacerdadev.course.repositories.CategoryRepository;
import com.lacerdadev.course.repositories.OrderRepository;
import com.lacerdadev.course.repositories.ProductRepository;
import com.lacerdadev.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ProductRepository productRepository;

  @Override
  public void run(String... args) throws Exception {
    User user1 = new User("Mari Juana", "Marijuana@test.com", "420420420", "123456");
    User user2 = new User("john Doe", "JohnDoe@test.com", "999999999", "123456");

    userRepository.saveAll(Arrays.asList(user1, user2));

    Order order1 = new Order(Instant.parse("2023-12-02T19:40:13Z"), OrderStatus.PAID, user1);
    Order order2 = new Order(Instant.parse("2023-12-20T21:53:23Z"), OrderStatus.WAITING_PAYMENT, user2);
    Order order3 = new Order(Instant.parse("2023-12-24T10:00:20Z"), OrderStatus.WAITING_PAYMENT, user1);

    orderRepository.saveAll(Arrays.asList(order1, order2, order3));

    Category category1 = new Category("Electronics");
    Category category2 = new Category("Books");
    Category category3 = new Category("Computers");

    categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

    Product product1 = new Product("The Lord of the rings", "DESCRIPTION", 90.5, "");
    Product product2 = new Product("Smart TV", "DESCRIPTION", 2104.5, "");
    Product product3 = new Product("MacBook pro", "DESCRIPTION", 14045.0, "");
    Product product4 = new Product("PC Gamer", "DESCRIPTION", 6360.0, "");
    Product product5 = new Product("Rails for Dummies", "DESCRIPTION", 100.99, "");

    product1.getCategories().add(category2);
    product2.getCategories().add(category1);
    product2.getCategories().add(category3);
    product3.getCategories().add(category3);
    product4.getCategories().add(category3);
    product5.getCategories().add(category2);

    productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
  }
}