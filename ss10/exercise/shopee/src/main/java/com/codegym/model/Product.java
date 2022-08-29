package com.codegym.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "text")
    private String linkImg;
    private double price;
    private String description;

    public Product(String name, String linkImg, double price, String description) {
        this.name = name;
        this.linkImg = linkImg;
        this.price = price;
        this.description = description;
    }
}
