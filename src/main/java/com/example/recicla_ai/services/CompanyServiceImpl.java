package com.example.recicla_ai.services;

import org.springframework.stereotype.Service;

import com.example.recicla_ai.dtos.CompanyDTO;
import com.example.recicla_ai.exceptions.BusinessRuleException;
import com.example.recicla_ai.models.Category;
import com.example.recicla_ai.models.Company;
import com.example.recicla_ai.repositories.CategoryRepository;
import com.example.recicla_ai.repositories.CompanyRepository;

import jakarta.transaction.Transactional;
import java.util.List;
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

        List<Category> categories = categoryRepository.findAllById(companyDTO.getCategoryIds());

        if (categories.isEmpty()) {
            throw new BusinessRuleException("Categoria não encontrada");
        }
        
        company.setCategories(categories);
        
        return companyRepository.save(company);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Long id, CompanyDTO companyDTO) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new BusinessRuleException("Empresa não encontrada"));

        company.setName(companyDTO.getName());
        company.setWhatsapp(companyDTO.isWhatsapp());
        company.setPhone(companyDTO.getPhone());
        company.setAddress(companyDTO.getAddress());
        company.setZipCode(companyDTO.getZipCode());
        company.setLat(companyDTO.getLat());
        company.setLng(companyDTO.getLng());
        company.setPayment(companyDTO.isPayment());
        company.setResidentialCollection(companyDTO.isResidentialCollection());

        List<Category> categories = categoryRepository.findAllById(companyDTO.getCategoryIds());

        if (categories.isEmpty()) {
            throw new BusinessRuleException("Categoria não encontrada");
        }
        
        company.setCategories(categories);
        
        companyRepository.save(company);
    }
}
