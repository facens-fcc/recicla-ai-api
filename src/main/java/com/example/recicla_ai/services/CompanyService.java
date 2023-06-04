package com.example.recicla_ai.services;

import java.util.List;
import java.util.Optional;

import com.example.recicla_ai.models.Company;
import com.example.recicla_ai.dtos.CompanyDTO;
import com.example.recicla_ai.dtos.CompanyDataDTO;

public interface CompanyService {
  Company create(CompanyDTO companyDTO);
  void delete(Long id);
  void update(Long id, CompanyDTO companyDTO);    
  List<CompanyDataDTO> getAll();
  // List<Company> getAll();
  Optional<Company> getById(Long id);
  // public List<CompanyDTO> searchCompanies(SearchDataDTO searchData);
}
