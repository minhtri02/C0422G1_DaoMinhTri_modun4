package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @GetMapping("/")
    public String showHome(){
        return "/home";
    }

    @GetMapping("/list")
    public String showList(){
        return "facility/listFacility";
    }
}
