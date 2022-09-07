package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(String name,String categoryName,Pageable pageable) {
        return iBlogRepository.findAllByNameContainingAndCategoryName(name,categoryName,pageable);
    }

    @Override
    public Page<Blog> findAll(String name, Pageable pageable) {
        return this.iBlogRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllByCategory(Integer id) {
        return this.iBlogRepository.findAllByCategory_Id(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return this.iBlogRepository.findById(id).orElse(new Blog());
    }

    @Override
    public void deleteById(Integer id) {
        this.iBlogRepository.delete(findById(id));
    }
}
