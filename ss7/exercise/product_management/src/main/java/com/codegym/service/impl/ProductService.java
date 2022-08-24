package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return this.productRepository.findByNameContaining(name, pageable);
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        this.productRepository.delete(findById(id).get());
    }

    @Override
    public Optional<Product> findById(int id) {
        return this.productRepository.findById(id);
    }
}
