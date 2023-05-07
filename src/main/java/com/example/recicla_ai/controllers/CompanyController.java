package com.example.recicla_ai.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.recicla_ai.dtos.CompanyDTO;
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
        return this.companyService.create(companyDTO);
    }
}
