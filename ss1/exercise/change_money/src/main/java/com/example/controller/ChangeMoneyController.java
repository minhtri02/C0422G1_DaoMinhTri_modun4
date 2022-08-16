package com.example.controller;


import com.example.service.IChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class ChangeMoneyController {

    @Autowired
    private IChangeMoneyService iChangeMoneyService;

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("/home")
    public String result(@RequestParam String usd, Model model) {
        if (usd.isEmpty()) {
            model.addAttribute("vnd", "0");
        } else {
            double vnd = this.iChangeMoneyService.changeMoney((usd));
            model.addAttribute("vnd", vnd);
        }
        model.addAttribute("usd", usd);
        return "/home";
    }
}
