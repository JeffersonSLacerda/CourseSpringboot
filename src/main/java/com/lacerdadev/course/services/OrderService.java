package com.lacerdadev.course.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacerdadev.course.entities.Order;
import com.lacerdadev.course.repositories.OrderRepository;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  public Order findById(UUID orderId) {
    Optional<Order> order = orderRepository.findById(orderId);
    return order.get();
  }
}