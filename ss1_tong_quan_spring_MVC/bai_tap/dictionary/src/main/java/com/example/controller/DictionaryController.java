package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/goDictinary")
    public  String goTuDien(){
        return "dictionary";
    }

    @PostMapping("/search")
    public String search(@RequestParam String vocabulary, Model model){
        String vie = this.iDictionaryService.getDictionary(vocabulary);
        if (vie==null){
            model.addAttribute("error", "không tìm thấy!");
        }else{
            model.addAttribute("vie", vie);
        }
        return "dictionary";
    }

}
