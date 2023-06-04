package com.example.recicla_ai.services;

import java.util.List;
import java.util.Optional;

import com.example.recicla_ai.dtos.CategoryDTO;
import com.example.recicla_ai.dtos.CategoryDataDTO;
import com.example.recicla_ai.models.Category;

public interface CategoryService {
    Category create(CategoryDTO categoryDTO);
    void delete(Long id);
    void update(Long id, CategoryDTO categoryDTO);
    List<Category> getAll();
    Optional<Category> getById(Long id);
    List<CategoryDataDTO> getCompaniesByCategoryDataDTO(List<Long> categoryIds);
}
