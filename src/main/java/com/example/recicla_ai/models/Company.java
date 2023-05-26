package com.example.recicla_ai.models;

import java.util.ArrayList;
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
  @ManyToMany(mappedBy = "companies", cascade = CascadeType.ALL)
  private List<Category> categories = new ArrayList<>();
  private boolean payment;
  @Column(name = "residential_collection")
  private boolean residentialCollection;

  @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", whatsapp=" + whatsapp + ", phoneDdi=" + phoneDdi
                + ", phoneDdd=" + phoneDdd + ", phoneNumber=" + phoneNumber + ", addressStreet=" + addressStreet
                + ", addressNumber=" + addressNumber + ", addressNeighborhood=" + addressNeighborhood + ", city=" + city
                + ", state=" + state + ", zipCode=" + zipCode + ", lat=" + lat + ", lng=" + lng + ", categories="
                + categories + ", payment=" + payment + ", residentialCollection=" + residentialCollection + "]";
    }
}