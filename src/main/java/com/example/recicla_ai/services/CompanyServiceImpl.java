package com.example.recicla_ai.services;

import org.springframework.stereotype.Service;

import com.example.recicla_ai.dtos.CompanyDTO;
import com.example.recicla_ai.exceptions.BusinessRuleException;
import com.example.recicla_ai.models.Category;
import com.example.recicla_ai.models.Company;
import com.example.recicla_ai.repositories.CategoryRepository;
import com.example.recicla_ai.repositories.CompanyRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Company create(CompanyDTO companyDTO) {

        Company company = new Company();
        company.setName(companyDTO.getName());
        company.setWhatsapp(companyDTO.isWhatsapp());
        company.setPhone(companyDTO.getPhone());
        company.setAddress(companyDTO.getAddress());
        company.setZipCode(companyDTO.getZipCode());
        company.setLat(companyDTO.getLat());
        company.setLng(companyDTO.getLng());
        company.setPayment(companyDTO.isPayment());
        company.setResidentialCollection(companyDTO.isResidentialCollection());

        Company savedCompany = companyRepository.save(company);

        if (companyDTO.getCategoryIds() != null && !companyDTO.getCategoryIds().isEmpty()) {
            for (Long categoryId : companyDTO.getCategoryIds()) {
                Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new BusinessRuleException("Category not found with ID: " + categoryId));
                category.getCompanies().add(savedCompany);
                categoryRepository.save(category);
            }
        }
        return savedCompany;

        
        // List<Category> categories = new ArrayList<>();
        // for (Long categoryId : companyDTO.getCategoryIds()) {
        //     Category category = categoryRepository.findById(categoryId)
        //         .orElseThrow(() -> new BusinessRuleException("Category not found with ID: " + categoryId));
        //     categories.add(category);
        // }

        // company.setCategories(categories);

        // return companyRepository.save(company);
    }
}
