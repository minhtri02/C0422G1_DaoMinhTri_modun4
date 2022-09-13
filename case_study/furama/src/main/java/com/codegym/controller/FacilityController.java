package com.codegym.controller;

import com.codegym.dto.FacilityDto;
import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
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
         model.addAttribute("facilityDto",new FacilityDto());
        model.addAttribute("facilityType",this.iFacilityService.listFacilityType());
        model.addAttribute("rentType",this.iFacilityService.listRentType());
        return "/facility/add";
    }

    @PostMapping("/add")
    public  String addFacility(@ModelAttribute("facilityDto") @Valid FacilityDto facilityDto, BindingResult bindingResult
            ,Model model, RedirectAttributes redirectAttributes){
        new FacilityDto().validate(facilityDto,bindingResult);

        if (bindingResult.hasErrors()){
            model.addAttribute("facilityDto",facilityDto);
            model.addAttribute("facilityType",this.iFacilityService.listFacilityType());
            model.addAttribute("rentType",this.iFacilityService.listRentType());
            return "/facility/add";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        this.iFacilityService.saveFacility(facility);
        redirectAttributes.addFlashAttribute("msg","Create success");
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
    public String edit(@ModelAttribute Facility facility,RedirectAttributes redirectAttributes){
        this.iFacilityService.saveFacility(facility);
        redirectAttributes.addFlashAttribute("smg","edit success!");
        return "redirect:/facility/";
    }

    @PostMapping("/delete")
    public String deleteFacility(@RequestParam("id") Integer id,RedirectAttributes redirectAttributes){
        this.iFacilityService.deleteFacility(id);
        redirectAttributes.addFlashAttribute("smg","delete success!");
        return "redirect:/facility/";
    }
}
