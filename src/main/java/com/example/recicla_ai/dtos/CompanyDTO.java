package com.example.recicla_ai.dtos;

import java.util.Set;

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
  private String phoneDdi;
  private String phoneDdd;
  private String phoneNumber;
  private String addressStreet;
  private String addressNumber;
  private String addressNeighborhood;
  private String city;
  private String state;
  private String zipCode;
  private double lat;
  private double lng;
  private boolean payment;
  private boolean residentialCollection;
  private Set<Long> categoryIds;
  private double distance;
}
