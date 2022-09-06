package com.codegym.controller.rest;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/blogrest")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/listcategory")
    public ResponseEntity<Page<Category>> showListCategory(@PageableDefault(size = 2)Pageable pageable){
        Page<Category> categoryPage = this.iCategoryService.findAll(pageable);

        if (!categoryPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categoryPage,HttpStatus.OK);
    }

    @GetMapping("/listblog")
    public ResponseEntity<Page<Blog>> showListBlog(@PageableDefault Pageable pageable, @RequestParam String name){
        Page<Blog> blogServiceAll = this.iBlogService.findAll(name,pageable);

        if (!blogServiceAll.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogServiceAll,HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> showListBlogInCategory(@PathVariable("id") Integer id){
        List<Blog> blogList = this.iBlogService.findAllByCategory(id);

        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable("id") Integer id){
        Blog blog = this.iBlogService.findById(id);

        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blog,HttpStatus.OK);
    }


}
