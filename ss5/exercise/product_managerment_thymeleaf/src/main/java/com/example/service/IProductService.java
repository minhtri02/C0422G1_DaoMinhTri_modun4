package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll(String name);

    Product findById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(int id);
}
