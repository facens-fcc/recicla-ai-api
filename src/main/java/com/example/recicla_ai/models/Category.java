package com.example.recicla_ai.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private String icon;    
    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER, cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
      })
    private Set<Company> companies;

    // public void addCompany(Company company) {
    //   companies.add(company);
    //   company.getCategories().add(this);
    // }

    // public void removeCompany(Company company) {
    //     companies.remove(company);
    //     company.getCategories().remove(this);
    // }

    @Override
    public String toString() {
    return "Category [id=" + id + ", label=" + label + ", icon=" + icon + "]";
    }
}
