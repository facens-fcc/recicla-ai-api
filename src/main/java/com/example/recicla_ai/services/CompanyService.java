package com.example.recicla_ai.services;

import java.util.List;

import com.example.recicla_ai.models.Company;
import com.example.recicla_ai.dtos.CompanyDTO;
import com.example.recicla_ai.dtos.SearchDataDTO;

public interface CompanyService {
  Company create(CompanyDTO companyDTO);
  void delete(Long id);
  void update(Long id, CompanyDTO companyDTO);    
  List<Company> getAll();
  public List<CompanyDTO> searchCompanies(SearchDataDTO searchData);
}
