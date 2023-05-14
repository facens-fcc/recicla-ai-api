package com.example.recicla_ai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.recicla_ai.dtos.CategoryDTO;
import com.example.recicla_ai.models.Category;
import com.example.recicla_ai.repositories.CategoryRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;

  @Override
  @Transactional
  public Category create(CategoryDTO categoryDTO) {
    Category category = new Category();
    category.setName(categoryDTO.getName());
    category.setIcon(categoryDTO.getIcon());
    // category.setCompanies(new ArrayList<>());

    return categoryRepository.save(category);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    categoryRepository.deleteById(id);
  }

  @Override
    @Transactional
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll();
    }
}
