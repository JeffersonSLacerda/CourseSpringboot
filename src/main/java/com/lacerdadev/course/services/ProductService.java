package com.lacerdadev.course.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacerdadev.course.entities.Product;
import com.lacerdadev.course.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findById(UUID productId) {
    Optional<Product> product = productRepository.findById(productId);
    return product.get();
  }
}