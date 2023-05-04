package com.example.recicla_ai.services;

import com.example.recicla_ai.dtos.CategoryDTO;
import com.example.recicla_ai.models.Category;

public interface CategoryService {
    Category create(CategoryDTO categoryDTO);
    // void delete(Long id);
    // void update(Long id, CategoryDTO categoryDTO);
}
