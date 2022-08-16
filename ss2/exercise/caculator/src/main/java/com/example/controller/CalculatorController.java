package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculator")
    public String addition(@RequestParam String num1, @RequestParam String num2,
                           @RequestParam String operator, Model model) {
        try {
            model.addAttribute("result", this.iCalculatorService.calculator(Double.parseDouble(num1),
                    Double.parseDouble(num2), operator));
        } catch (NumberFormatException e) {
            model.addAttribute("result", "please enter number!");
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "index";
    }
}
