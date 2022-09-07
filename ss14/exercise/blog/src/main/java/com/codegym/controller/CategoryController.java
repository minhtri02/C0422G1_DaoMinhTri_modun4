package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService icategoryService;

    @GetMapping("/list")
    public ModelAndView showCategory(){
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categoryList",this.icategoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/deleteCategory")
    public String delete(@RequestParam int id) {
        this.icategoryService.deleteById(id);
        return "redirect:/category/list";
    }

    @GetMapping("/createCategory")
    public String goAdd(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/createCategory")
    public String save(@ModelAttribute Category category) {
        this.icategoryService.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/updateCategory")
    public String goEdit(@RequestParam int id, Model model) {
        model.addAttribute("category", this.icategoryService.findById(id));
        return "category/update";
    }

    @PostMapping("/updateCategory")
    public String saveEdit(@ModelAttribute Category category) {
        this.icategoryService.save(category);
        return "redirect:/category/list";
    }
}