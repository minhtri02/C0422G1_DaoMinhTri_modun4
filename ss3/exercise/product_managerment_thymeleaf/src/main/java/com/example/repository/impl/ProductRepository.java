package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "beroca", "10000", "ngon", "viet nam"));
        productList.add(new Product(2, "Deebo", "10000", "ngon", "viet nam"));
        productList.add(new Product(3, "phone", "10000", "ngon", "viet nam"));
        productList.add(new Product(4, "pen", "10000", "rẻ", "viet nam"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }


    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void editProduct(Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescribe(product.getDescribe());
                p.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(productList.get(i));
            }
        }
    }
}
