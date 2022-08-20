package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll(String name) {
        if (name == null) {
            TypedQuery typedQuery = BaseRepository.entityManager.createQuery("select p from Product p", Product.class);
            return typedQuery.getResultList();
        } else {
            TypedQuery typedQuery = BaseRepository.entityManager.createQuery("select p from Product p where p.name like concat('%',:name,'%') ", Product.class);
            typedQuery.setParameter("name", name);
            return typedQuery.getResultList();
        }
    }


    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public void addProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void editProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void deleteProduct(int id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }
}
