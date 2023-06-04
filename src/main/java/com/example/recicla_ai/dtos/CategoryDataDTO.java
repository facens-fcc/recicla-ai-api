package com.example.recicla_ai.dtos;

import java.util.Set;

import com.example.recicla_ai.models.Company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDataDTO {
    private Long id;
    private String label;
    private String icon;
    private Set<Company> companies; 
}
