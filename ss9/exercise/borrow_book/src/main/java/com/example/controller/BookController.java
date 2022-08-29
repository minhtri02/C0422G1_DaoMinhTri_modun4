package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String listBook(@PageableDefault(size = 2) Pageable pageable,
                           Model model,
                           @RequestParam Optional<String> name){
        String keyName = name.orElse("");
        model.addAttribute("bookPage", iBookService.findAllBook(keyName, pageable));
        model.addAttribute("keyName", keyName);
        return "list";
    }

    @GetMapping("/info/{id}")
    public String bookInfo(@PathVariable Long id, Model model){
        model.addAttribute("book", iBookService.findById(id));
        return "info";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long id, Model model) throws Exception {
        Book book = iBookService.findById(id);
        if (book.getAmount() == 0){
            throw new Exception();
        }else {
            iBookService.borrowBook(id);
            model.addAttribute("book", iBookService.findById(id));
            return "info";
        }
    }

    @GetMapping("/giveBack")
    public String giveBackForm(){
        return "give";
    }

    @PostMapping("/give")
    public String giveBack(@RequestParam long id) throws Exception {
        Book book = iBookService.findById(id);
        if (book.getAmount() == book.getTotalAmount()){
            throw new Exception();
        }else {
            iBookService.giveBookBack(id);
            return "give";
        }
    }

    @ExceptionHandler(value = Exception.class)
    public String errors(){
        return "error";
    }
}
