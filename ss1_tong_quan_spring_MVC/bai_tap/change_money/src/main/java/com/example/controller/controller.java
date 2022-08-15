package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {

    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @GetMapping("/home")
    public String resurl(@RequestParam String usd, Model model){
        if (usd.isEmpty()){
            model.addAttribute("vnd","0");
        }
        else {
            try{
                double vnd = Double.parseDouble(usd) *23000;
                model.addAttribute("vnd",vnd);
            }catch (NumberFormatException e){
                model.addAttribute("vnd","không xác định!");
            }
        }
       model.addAttribute("usd",usd);
       return "/home";

    }
}
