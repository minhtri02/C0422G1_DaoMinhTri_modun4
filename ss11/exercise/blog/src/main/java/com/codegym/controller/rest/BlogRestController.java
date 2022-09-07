package com.codegym.controller.rest;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/blogRest")
@org.springframework.web.bind.annotation.RestController
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public ResponseEntity<Page<Blog>> showListBlog(@PageableDefault Pageable pageable, @RequestParam String name){
        Page<Blog> blogServiceAll = this.iBlogService.findAll(name,pageable);

        if (!blogServiceAll.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogServiceAll,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable("id") Integer id){
        Blog blog = this.iBlogService.findById(id);

        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
