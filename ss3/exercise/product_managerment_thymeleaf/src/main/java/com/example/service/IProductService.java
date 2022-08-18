package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    List<Product> searchByName(String name);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(int id);
}
