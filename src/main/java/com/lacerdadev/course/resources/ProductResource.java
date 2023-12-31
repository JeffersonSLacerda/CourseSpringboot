package com.lacerdadev.course.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacerdadev.course.entities.Product;
import com.lacerdadev.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    List<Product> products = productService.findAll();
    return ResponseEntity.ok().body(products);
  }

  @GetMapping(value = "/{productId}")
  public ResponseEntity<Product> findById(@PathVariable UUID productId) {
    Product product = productService.findById(productId);

    return ResponseEntity.ok().body(product);
  }
}