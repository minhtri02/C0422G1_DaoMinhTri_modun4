package com.example.register_form.controller;

import com.example.register_form.dto.UserDto;
import com.example.register_form.model.User;
import com.example.register_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String goAddUser(Model model) {
        model.addAttribute("userDto", new UserDto());

        return "/user/add";
    }

    @PostMapping("/createUser")
    public String addUser(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult bindingResult, Model model) {
        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "/user/add";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.add(user);
        model.addAttribute("msg", "access");
        return "/user/list";
    }
}
