package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ICartService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Map<Product, Integer> createCart() {
        return new HashMap<>();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", this.iProductService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam("id") Long id,@RequestParam("expression") String expression, @SessionAttribute("cart")  Map<Product, Integer> cart,Model model) {
        Product product = this.iProductService.findById(id);
        iCartService.addProduct(cart,product,expression);
        model.addAttribute("total", iCartService.getTotal(cart));
        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }


    @GetMapping("/detail")
    public String goDetail(@RequestParam Long id, Model model) {
        Product product = iProductService.findById(id);
        if (product == null) {
            return "/error.404";
        }
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/cart")
    public String goCart(Model model, @SessionAttribute("cart") Map<Product, Integer> cart) {
        double total = this.iCartService.getTotal(cart);
        model.addAttribute("cart",cart);
        model.addAttribute("total",total);
        return "cart";
    }

    @GetMapping("/pay")
    public String payProduct(@SessionAttribute("cart") Map<Product, Integer> cart){
        cart.clear();
        return "pay";
    }
}
