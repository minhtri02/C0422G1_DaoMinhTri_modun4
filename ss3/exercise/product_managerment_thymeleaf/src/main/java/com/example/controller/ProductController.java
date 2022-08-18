package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String showProductList(Model model) {
        List<Product> list = this.iProductService.findAll();
        model.addAttribute("productList", list);
        return "listProduct";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/createProduct";
    }

    @PostMapping("/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 10000));
        this.iProductService.addProduct(product);
        redirectAttributes.addFlashAttribute("msg", "create success");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/editProduct";
    }

    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.editProduct(product);
        redirectAttributes.addFlashAttribute("msg", "edit success");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        this.iProductService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("msg", "delete success");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/viewProduct";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String name, Model model) {
        List<Product> productList = this.iProductService.searchByName(name);
        model.addAttribute("productList", productList);
        return "listProduct";
    }
}
