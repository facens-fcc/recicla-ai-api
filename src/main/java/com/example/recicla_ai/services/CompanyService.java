package com.example.recicla_ai.services;

import com.example.recicla_ai.models.Company;

public interface CompanyService {
  Company create(Company company);
  void delete(Long id);
  void update(Long id, Company company);    
}
