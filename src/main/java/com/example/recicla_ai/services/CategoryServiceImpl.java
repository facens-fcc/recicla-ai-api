package com.example.recicla_ai.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.recicla_ai.dtos.CategoryDTO;
import com.example.recicla_ai.exceptions.BusinessRuleException;
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
    category.setName(categoryDTO.getName());
    category.setIcon(categoryDTO.getIcon());
    category.setCompanies(new ArrayList<>());

    Category savedCategory = categoryRepository.save(category);

    if (categoryDTO.getCompanyIds() != null && !categoryDTO.getCompanyIds().isEmpty()) {
      for (Long companyId : categoryDTO.getCompanyIds()) {
        Company company = companyRepository.findById(companyId)
            .orElseThrow(() -> new BusinessRuleException("Company not found with ID: " + companyId));
        company.getCategories().add(savedCategory);
        companyRepository.save(company);
      }
    }

    return savedCategory;
  }
}
