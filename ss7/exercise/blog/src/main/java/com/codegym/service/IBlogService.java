package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(String name,String category_name,Pageable pageable);
    void save(Blog blog);
    void update(Blog blog);
    Blog findById(Integer id);
    void deleteById(Integer id);
}
