package com.lacerdadev.course.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacerdadev.course.entities.User;
import com.lacerdadev.course.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(UUID userId) {
    Optional<User> user = userRepository.findById(userId);
    return user.get();
  }
}