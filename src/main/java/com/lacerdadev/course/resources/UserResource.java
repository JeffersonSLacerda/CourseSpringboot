package com.lacerdadev.course.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacerdadev.course.entities.User;
import com.lacerdadev.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> users = userService.findAll();
    return ResponseEntity.ok().body(users);
  }

  @GetMapping(value = "/{userId}")
  public ResponseEntity<User> findById(@PathVariable UUID userId) {
    User user = userService.findById(userId);

    return ResponseEntity.ok().body(user);
  }
}