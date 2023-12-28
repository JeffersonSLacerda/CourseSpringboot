package com.lacerdadev.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lacerdadev.course.entities.Order;
import com.lacerdadev.course.entities.User;
import com.lacerdadev.course.repositories.OrderRepository;
import com.lacerdadev.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public void run(String... args) throws Exception {
    User user1 = new User("Mari Juana", "Marijuana@test.com", "420420420", "123456");
    User user2 = new User("john Doe", "JohnDoe@test.com", "999999999", "123456");

    userRepository.saveAll(Arrays.asList(user1, user2));

    Order order1 = new Order(Instant.parse("2023-12-02T19:40:13Z"), user1);
    Order order2 = new Order(Instant.parse("2023-12-20T21:53:23Z"), user2);
    Order order3 = new Order(Instant.parse("2023-12-24T10:00:20Z"), user1);

    orderRepository.saveAll(Arrays.asList(order1, order2, order3));
  }
}