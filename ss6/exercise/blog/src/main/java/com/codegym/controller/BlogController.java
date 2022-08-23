package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/home")
    public ModelAndView goListBlog(Model model){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("listBlog",this.iBlogService.findAll());
        return modelAndView;
    }

    @GetMapping("/createBlog")
    public ModelAndView goCreateBlog(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/createBlog")
    public ModelAndView createBlog(@ModelAttribute Blog blog){
        ModelAndView modelAndView = new ModelAndView("create");
        this.iBlogService.save(blog);
        modelAndView.addObject("message","create success!");
        return modelAndView;
    }

    @GetMapping("/updateBlog/{id}")
    public ModelAndView goUpdateBlog(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("blog",this.iBlogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/updateBlog")
    public ModelAndView updateBlog(@ModelAttribute Blog blog){
        ModelAndView modelAndView=new ModelAndView("update");
        this.iBlogService.save(blog);
        modelAndView.addObject("message","update success!");
        return modelAndView;
    }

    @PostMapping("deleteBlog")
    public ModelAndView deleteBlog(@RequestParam Integer id){
        ModelAndView modelAndView =new ModelAndView("list");
        this.iBlogService.deleteById(id);
        modelAndView.addObject("message","delete success!");
        return modelAndView;
    }

    @GetMapping("/viewBlog/{id}")
    public ModelAndView goViewBlog(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("blog",this.iBlogService.findById(id));
        return modelAndView;
    }
}
