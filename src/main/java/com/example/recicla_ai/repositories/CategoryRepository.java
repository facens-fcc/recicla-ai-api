package com.example.recicla_ai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recicla_ai.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
