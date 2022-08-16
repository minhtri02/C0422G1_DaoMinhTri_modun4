package com.example.controller;

import com.example.service.ISpiceSandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceSandwichController {

    @Autowired
    private ISpiceSandwichService iSpiceSandwichService;

    @GetMapping("/spiceSandwich")
    public String goSpiceSandwich(Model model) {
        model.addAttribute("list", this.iSpiceSandwichService.findAll());
        return "home";
    }

    @PostMapping("/save")
    public String save(@RequestParam(required = false) String[] spice, Model model) {
        if (spice==null){
            model.addAttribute("message","Please choose your seasoning!");
            model.addAttribute("list", this.iSpiceSandwichService.findAll());
            return "home";
        }
        model.addAttribute("list", this.iSpiceSandwichService.findAll());
        model.addAttribute("listSpice", this.iSpiceSandwichService.findSpice(spice));
        return "home";
    }
}
