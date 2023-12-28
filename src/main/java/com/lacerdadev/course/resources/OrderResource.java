package com.lacerdadev.course.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacerdadev.course.entities.Order;
import com.lacerdadev.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

  @Autowired
  private OrderService orderService;

  @GetMapping
  public ResponseEntity<List<Order>> findAll() {
    List<Order> orders = orderService.findAll();
    return ResponseEntity.ok().body(orders);
  }

  @GetMapping(value = "/{orderId}")
  public ResponseEntity<Order> findById(@PathVariable UUID userId) {
    Order order = orderService.findById(userId);

    return ResponseEntity.ok().body(order);
  }
}