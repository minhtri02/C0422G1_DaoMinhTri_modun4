package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

//    @GetMapping("/")
//    public String greeting(){
////        model.addAttribute("name1",name1);
//        return "/list";
//    }
    @GetMapping("/")
    public String home(){
        return "/index";
    }


}
