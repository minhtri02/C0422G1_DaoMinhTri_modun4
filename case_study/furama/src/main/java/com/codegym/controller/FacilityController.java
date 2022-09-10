package com.codegym.controller;

import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    IFacilityService iFacilityService;

    @GetMapping("/")
    public String showList(Model model, @RequestParam Optional<String> name,@PageableDefault(size = 4) Pageable pageable){
        String keyName = name.orElse("");
        model.addAttribute("facilityPage",this.iFacilityService.listFacility(keyName,pageable));

        model.addAttribute("keyName",keyName);
        return "/facility/list";
    }

    @GetMapping("/add")
    public String showAdd(Model model){
         model.addAttribute("facility",new Facility());
        model.addAttribute("facilityType",this.iFacilityService.listFacilityType());
        model.addAttribute("rentType",this.iFacilityService.listRentType());
        return "/facility/add";
    }

    @PostMapping("/add")
    public  String addFacility(@ModelAttribute Facility facility){
        this.iFacilityService.saveFacility(facility);
        return "redirect:/facility/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id,Model model){
        model.addAttribute("facility",this.iFacilityService.findById(id));
        model.addAttribute("facilityType",this.iFacilityService.listFacilityType());
        model.addAttribute("rentType",this.iFacilityService.listRentType());
        return "/facility/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Facility facility){
        this.iFacilityService.saveFacility(facility);
        return "redirect:/facility/";
    }
}
