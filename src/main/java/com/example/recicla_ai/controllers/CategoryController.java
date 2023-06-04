package com.example.recicla_ai.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.recicla_ai.dtos.CategoryDTO;
import com.example.recicla_ai.models.Category;
import com.example.recicla_ai.services.CategoryService;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/categories")
public class CategoryController {
  private CategoryService categoryService;
  
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Category create(@RequestBody CategoryDTO categoryDTO) {
    return categoryService.create(categoryDTO);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    categoryService.delete(id);
  }

  @GetMapping
  public List<Category> getAll() {
    return categoryService.getAll();
  }

  @PutMapping("{id}")
  public void update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
      categoryService.update(id, categoryDTO);
  }
}
