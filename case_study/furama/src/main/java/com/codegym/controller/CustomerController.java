package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.IGuestTypeCustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private IGuestTypeCustomerService iGuestTypeCustomerService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/")
    public String showListCustomer(Model model,@RequestParam Optional<String> name, @PageableDefault(size = 4) Pageable pageable){
        String keyName = name.orElse("");
        model.addAttribute("listCustomer",this.iCustomerService.findAll(keyName,pageable));
        model.addAttribute("keyName",keyName);
        return "/customer/list";
    }

    @GetMapping("/add")
    public String showAddCustomer(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("listGuestType",this.iGuestTypeCustomerService.findAll());
        return "/customer/add";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customerDto")@Valid CustomerDto customerDto, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "/customer/add";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","create success");
        return "redirect:/customer/";
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomer(@PathVariable Integer id,Model model){
        model.addAttribute("customer",this.iCustomerService.findById(id));
        model.addAttribute("listGuest",this.iGuestTypeCustomerService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer){
        this.iCustomerService.save(customer);
        return "redirect:/customer/";
    }

    @PostMapping("/delete")
    public String editCustomer(@RequestParam Integer id){
        this.iCustomerService.delete(id);
        return "redirect:/customer/";
    }
}
