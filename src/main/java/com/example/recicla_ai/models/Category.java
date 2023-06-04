package com.example.recicla_ai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private String icon;    
    // @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER, cascade = {
    //     CascadeType.PERSIST,
    //     CascadeType.MERGE
    //   })
    // private Set<Company> companies;

    @Override
    public String toString() {
    return "Category [id=" + id + ", label=" + label + ", icon=" + icon + "]";
    }
}
