package com.example.recicla_ai.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recicla_ai.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    default List<Category> findAllById(Iterable<Long> ids) {
        List<Category> categories = new ArrayList<>();
        for (Long id : ids) {
            Optional<Category> category = findById(id);
            category.ifPresent(categories::add);
        }
        return categories;
    }
}
