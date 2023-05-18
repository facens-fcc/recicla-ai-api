package com.example.recicla_ai.services;

import java.util.List;

import com.example.recicla_ai.models.Category;
import com.example.recicla_ai.models.Company;
import com.example.recicla_ai.dtos.CompanyDTO;

public interface CompanyService {
  Company create(CompanyDTO companyDTO);
  void delete(Long id);
  void update(Long id, CompanyDTO companyDTO);    
  List<Company> getAll();
}
