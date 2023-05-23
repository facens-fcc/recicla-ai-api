package com.example.recicla_ai.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.recicla_ai.dtos.CompanyDTO;
import com.example.recicla_ai.dtos.SearchDataDTO;
import com.example.recicla_ai.models.Company;
import com.example.recicla_ai.services.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {    
    private CompanyService companyService;
  
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@RequestBody CompanyDTO companyDTO) {
        return companyService.create(companyDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    } 

    @GetMapping
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        companyService.update(id, companyDTO);
    }

    @PostMapping("/search")
    public List<CompanyDTO> searchCompanies(@RequestBody SearchDataDTO SearchData) {
        return companyService.searchCompanies(SearchData);
    }
}