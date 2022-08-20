package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll(String name);

    Product findById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(int id);

}
