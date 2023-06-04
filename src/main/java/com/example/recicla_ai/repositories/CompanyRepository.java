package com.example.recicla_ai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recicla_ai.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
