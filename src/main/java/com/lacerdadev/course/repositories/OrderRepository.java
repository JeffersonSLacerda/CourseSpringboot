package com.lacerdadev.course.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacerdadev.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}