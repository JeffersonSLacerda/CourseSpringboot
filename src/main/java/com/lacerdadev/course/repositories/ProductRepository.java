package com.lacerdadev.course.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacerdadev.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}