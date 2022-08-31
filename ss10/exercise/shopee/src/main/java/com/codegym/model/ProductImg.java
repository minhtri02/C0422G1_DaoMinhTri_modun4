package com.codegym.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "product_img")
public class ProductImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String link;
    @ManyToOne
    @JoinColumn(name = "img_link",referencedColumnName = "id")
    private Product product;
}
