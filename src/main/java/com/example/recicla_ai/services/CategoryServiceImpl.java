package com.example.recicla_ai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recicla_ai.dtos.CategoryDTO;
import com.example.recicla_ai.dtos.CategoryDataDTO;
import com.example.recicla_ai.models.Category;
import com.example.recicla_ai.models.Company;
import com.example.recicla_ai.repositories.CategoryRepository;
import com.example.recicla_ai.repositories.CompanyRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;
  private final CompanyRepository companyRepository;

  @Override
  @Transactional
  public Category create(CategoryDTO categoryDTO) {
    Category category = new Category();
    category.setLabel(categoryDTO.getLabel());
    category.setIcon(categoryDTO.getIcon());

    return categoryRepository.save(category);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    categoryRepository.deleteById(id);
  }

  @Override
  @Transactional
  public List<Category> getAll() {
      return categoryRepository.findAll();
  }

  @Override
  @Transactional
  public Optional<Category> getById(Long id) {
      return categoryRepository.findById(id);
  }

  @Override
  @Transactional
  public List<CategoryDataDTO> getCompaniesByCategoryDataDTO(List<Long> categoryIds) {
    List<Category> categories = categoryRepository.findAllById(categoryIds);
    List<Company> companies = companyRepository.findAll();
    List<CategoryDataDTO> categoryData = new ArrayList<>();

    for (Category category : categories) {
      Set<Company> relatedCompanies = new HashSet<>();
      for (Company company : companies) {
        if (company.getCategories().contains(category)) {
          relatedCompanies.add(company);
        }
      }

      CategoryDataDTO categoryDataDTO = CategoryDataDTO.builder()
                .id(category.getId())
                .label(category.getLabel())
                .icon(category.getIcon())
                .companies(relatedCompanies)
                .build();
        categoryData.add(categoryDataDTO);
    }
    return categoryData;
  }
  
  @Override
  @Transactional
  public void update(Long id, CategoryDTO categoryDTO) {
    Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

    category.setLabel(categoryDTO.getLabel());
    category.setIcon(categoryDTO.getIcon());

    categoryRepository.save(category);
  }
}
