package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return this.iCategoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return this.iCategoryRepository.findAll(pageable);
    }


    @Override
    public void save(Category category) {
        this.iCategoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return this.iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        this.iCategoryRepository.deleteById(id);
    }
}
