package com.example.recicla_ai.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
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
  private String phoneDdi;
  private String phoneDdd;
  private String phoneNumber;
  private String addressStreet;
  private String addressNumber;
  private String addressNeighborhood;
  private String city;
  private String state;
  @Column(name = "zip_code")
  private String zipCode;
  private double lat;
  private double lng;
  private boolean payment;
  @Column(name = "residential_collection")
  private boolean residentialCollection;
  @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(
      name = "company_categories",
      joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
  )
  private Set<Category> categories = new HashSet<>();

  // public void addCategory(Category category) {
  //   categories.add(category);
  //   category.getCompanies().add(this);
  // }

  // public void removeCategory(Category category) {
  //     categories.remove(category);
  //     category.getCompanies().remove(this);
  // }
}