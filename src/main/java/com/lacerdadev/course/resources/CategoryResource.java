package com.lacerdadev.course.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacerdadev.course.entities.Category;
import com.lacerdadev.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  @Autowired
  private CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    List<Category> categories = categoryService.findAll();
    return ResponseEntity.ok().body(categories);
  }

  @GetMapping(value = "/{categoryId}")
  public ResponseEntity<Category> findById(@PathVariable UUID categoryId) {
    Category category = categoryService.findById(categoryId);

    return ResponseEntity.ok().body(category);
  }
}