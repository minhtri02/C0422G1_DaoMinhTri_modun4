package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public ModelAndView home(@PageableDefault(size = 4) Pageable pageable) {
        Page<Contract> contractPage = contractService.listContract(pageable);
        ModelAndView modelAndView = new ModelAndView("/contract/list");
        return modelAndView;
    }

    @GetMapping("/list")
    public String listFacility(@PageableDefault(size = 5) Pageable pageable,
                               Model model) {
        Page<Contract> contractPage = contractService.listContract(pageable);
        Map<Long, Double> map = new HashMap<>();
        List<Contract> contractList = contractService.findAll();
        double totalMoney;
        for (Contract c : contractList) {
            totalMoney = 0;
            for (ContractDetail cd : c.getContractDetail()) {
                totalMoney += cd.getQuantity() * cd.getAttachFacility().getCost();
            }
            map.put(c.getId(), totalMoney);
        }
        model.addAttribute("total", map);
        model.addAttribute("attachFacility", contractService.listAttachFacility());
        model.addAttribute("contractPage", contractPage);

        model.addAttribute("contractDetailDto", new ContractDetailDto());
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customer", customerService.findAll(pageable));
        model.addAttribute("facility", facilityService.findAll());
        model.addAttribute("employee", employeeService.listEmployee());
        return "contract/list";
    }


    @GetMapping("/listContractDetail/{id}")
    public String listContractDetail(@PathVariable Long id, RedirectAttributes rd){
        rd.addFlashAttribute("contractDetail", contractService.listContractDetail(id));
        return "redirect:/contract/list";
    }
}


