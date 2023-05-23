package com.example.recicla_ai.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchDataDTO {
    private String zipCode;
    private List<Long> categoryIds;
}
