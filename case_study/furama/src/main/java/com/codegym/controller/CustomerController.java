package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.service.IGuestTypeCustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IGuestTypeCustomerService iGuestTypeCustomerService;

    @GetMapping("/")
    public String showListCustomer(Model model, Pageable pageable){
        model.addAttribute("listCustomer",this.iCustomerService.findAll(null,pageable));
        return "/customer/listCustomer";
    }

    @GetMapping("/add")
    public String showAddCustomer(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("listGuestType",this.iGuestTypeCustomerService.findAll());
        return "/customer/addCustomer";
    }
}
