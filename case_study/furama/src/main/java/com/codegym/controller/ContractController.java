package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

//    @GetMapping("")
//    public ModelAndView home(@PageableDefault(size = 4) Pageable pageable) {
//        Page<Contract> contractPage = contractService.listContract(pageable);
//        ModelAndView modelAndView = new ModelAndView("/contract/list");
//        return modelAndView;
//    }

    @GetMapping("/list")
    public String listFacility(@PageableDefault(size = 5) Pageable pageable,
                               @RequestParam Optional<String> facilityName,
                               @RequestParam Optional<String> customerName,
                               Model model) {
        String keyName = facilityName.orElse("");
        String keyCus = customerName.orElse("");
        Page<Contract> contractPage = contractService.listContract(keyName, keyCus, pageable);
        Map<Long, Double> map = new HashMap<>();
        List<Contract> contractList = contractService.findAll();
        double totalMoney;
        for (Contract contract : contractList) {
            totalMoney = 0;
            for (ContractDetail detail : contract.getContractDetail()) {
                totalMoney += detail.getQuantity() * detail.getAttachFacility().getCost();
            }
            map.put(contract.getId(), totalMoney);
        }
        model.addAttribute("total", map);
        model.addAttribute("attachFacility", contractService.listAttachFacility());
        model.addAttribute("contractPage", contractPage);
        model.addAttribute("keyName", keyName);
        model.addAttribute("keyCus", keyCus);

        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contract", new Contract());
        model.addAttribute("customer", customerService.findAll(pageable));
        model.addAttribute("facility", facilityService.findAll());
        model.addAttribute("employee", employeeService.listEmployee());
        return "contract/list";
    }

    @PostMapping("/createContractDetail")
    public String createContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        contractService.saveContractDetail(contractDetail);
        redirectAttributes.addFlashAttribute("msg", "create success");
        return "redirect:/contract/list";
    }
}


