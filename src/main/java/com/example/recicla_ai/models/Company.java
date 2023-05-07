package com.example.recicla_ai.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private boolean whatsapp;
  private String phone;
  private String address;
  @Column(name = "zip_code")
  private String zipCode;
  private double lat;
  private double lng;
  @ManyToMany(mappedBy = "companies", cascade = CascadeType.ALL)
  private List<Category> categories;
  private boolean payment;
  @Column(name = "residential_collection")
  private boolean residentialCollection;

  @Override
    public String toString() {
      return "Company [id=" + id + ", name=" + name + ", whatsapp=" + whatsapp + ", phone=" + phone + ", address=" + address + ", zipCode=" + zipCode + ", lat=" + lat + ", lng=" + lng + ", categories=" + categories + ", payment=" + payment + ", residentialCollection=" + residentialCollection + "]";
    }
}