package com.example.recicla_ai.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Boolean whatsapp;
  private String phone;
  private String address;
  @Column(name = "zip_code")
  private String zipCode;
  private Double lat;
  private Double lng;
  @ManyToMany(mappedBy = "companies")
  private List<Category> categories;
  private Boolean payment;
  @Column(name = "residential_collection")
  private Boolean residentialCollection;
}