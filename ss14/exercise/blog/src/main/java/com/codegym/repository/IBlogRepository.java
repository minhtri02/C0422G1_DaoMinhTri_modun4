package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAllByNameContainingAndCategoryName(String name,String categoryName, Pageable pageable);
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
    List<Blog> findAllByCategory(Integer id);
    List<Blog> findAllByCategory_Id(Integer id);
}
