package com.example.recicla_ai.dtos;

import java.util.List;

import com.example.recicla_ai.models.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDTO {
  private Long id;
  private String name;
  private Boolean whatsapp;
  private String phone;
  private String address;
  private String zipCode;
  private Double lat;
  private Double lng;
  private List<Category> categories;
  private Boolean payment;
  private Boolean residentialCollection;
}
