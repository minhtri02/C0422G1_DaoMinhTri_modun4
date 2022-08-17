package com.example.controller;

import com.example.model.BoxEmail;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {

    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/home")
    public String goHome(Model model) {
        model.addAttribute("language", this.iEmailService.languages());
        model.addAttribute("pageSize", this.iEmailService.pageSize());
        model.addAttribute("boxEmail", this.iEmailService.displayEmail());
        return "home";
    }

    @PostMapping("/showBoxEmail")
    public String boxEmail(@ModelAttribute BoxEmail boxEmail, RedirectAttributes redirectAttributes) {
        this.iEmailService.updateEmail(boxEmail);
        redirectAttributes.addFlashAttribute("boxEmail", boxEmail);
        return "showEmail";
    }
}
