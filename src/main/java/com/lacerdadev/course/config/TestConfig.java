package com.lacerdadev.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lacerdadev.course.entities.User;
import com.lacerdadev.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    User user1 = new User("Mari Juana", "Marijuana@test.com", "420420420", "123456");
    User user2 = new User("john Doe", "JohnDoe@test.com", "999999999", "123456");

    userRepository.saveAll(Arrays.asList(user1, user2));
  }
}