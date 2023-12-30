package com.lacerdadev.course.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacerdadev.course.entities.Category;
import com.lacerdadev.course.repositories.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(UUID categoryId) {
    Optional<Category> category = categoryRepository.findById(categoryId);
    return category.get();
  }
}