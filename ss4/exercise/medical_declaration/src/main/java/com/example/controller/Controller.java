package com.example.controller;

import com.example.model.Medical;
import com.example.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping("/")
    public String goMedical(Model model) {
        model.addAttribute("medical", new Medical());
        model.addAttribute("day", this.iMedicalService.getListDay());
        model.addAttribute("month", this.iMedicalService.getListMonth());
        model.addAttribute("year", this.iMedicalService.getListYear());
        model.addAttribute("nationality", this.iMedicalService.getListNationality());
        model.addAttribute("transport", this.iMedicalService.getListTransport());
        return "saveMedical";
    }

    @PostMapping("/save")
    public String goListMedical(@ModelAttribute Medical medical, Model model) {
        this.iMedicalService.saveMedical(medical);
        model.addAttribute("listMedical", this.iMedicalService.findAll());
        return "listMedical";
    }

    @GetMapping("/details")
    public String showList(@RequestParam int id, Model model) {
        Medical medical = this.iMedicalService.searchById(id);
        model.addAttribute("medical", medical);
        return "details";
    }

    @GetMapping("/edit")
    public String showUpdate(@RequestParam int id, Model model) {
        Medical medical = this.iMedicalService.searchById(id);
        model.addAttribute("MedicalDeclaration", medical);
        model.addAttribute("day", this.iMedicalService.getListDay());
        model.addAttribute("month", this.iMedicalService.getListMonth());
        model.addAttribute("year", this.iMedicalService.getListYear());
        model.addAttribute("nationality", this.iMedicalService.getListNationality());
        model.addAttribute("transport", this.iMedicalService.getListTransport());
        return "editMedical";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Medical medical1, @RequestParam int id) {
        this.iMedicalService.update(id, medical1);
        return "listMedical";
    }

}
