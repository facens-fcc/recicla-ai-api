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
public class CompanyDTO {
  private Long id;
  private String name;
  private boolean whatsapp;
  private String phone;
  private String address;
  private String zipCode;
  private double lat;
  private double lng;
  private boolean payment;
  private boolean residentialCollection;
  private List<Long> categoryIds;
}
