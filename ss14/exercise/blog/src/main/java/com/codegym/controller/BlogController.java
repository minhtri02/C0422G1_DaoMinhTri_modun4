package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/home")
    public ModelAndView goListBlog(@PageableDefault(size = 2) Pageable pageable,
                                   @RequestParam Optional<String> categoryName,
                                   @RequestParam Optional<String> nameBlog) {
        String keyWork = nameBlog.orElse("");
        String categorys = categoryName.orElse("");
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("listBlog", this.iBlogService.findAll(keyWork, categorys, pageable));
        modelAndView.addObject("categoryList", this.iCategoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/createBlog")
    public ModelAndView goCreateBlog() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categoryList", this.iCategoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/createBlog")
    public ModelAndView createBlog(@ModelAttribute Blog blog) {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        this.iBlogService.save(blog);
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categoryList", this.iCategoryService.findAll());
        modelAndView.addObject("message", "create success!");
        return modelAndView;
    }

    @GetMapping("/updateBlog/{id}")
    public ModelAndView goUpdateBlog(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("/blog/update");
        modelAndView.addObject("blog", this.iBlogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/updateBlog")
    public ModelAndView updateBlog(@ModelAttribute Blog blog) {
        ModelAndView modelAndView = new ModelAndView("/blog/update");
        this.iBlogService.save(blog);
        modelAndView.addObject("message", "update success!");
        return modelAndView;
    }

    @PostMapping("/deleteBlog")
    public ModelAndView deleteBlog(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog//home");
        this.iBlogService.deleteById(id);
        modelAndView.addObject("message", "delete success!");
        return modelAndView;
    }

    @GetMapping("/viewBlog/{id}")
    public ModelAndView goViewBlog(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        modelAndView.addObject("blog", this.iBlogService.findById(id));
        return modelAndView;
    }
}
