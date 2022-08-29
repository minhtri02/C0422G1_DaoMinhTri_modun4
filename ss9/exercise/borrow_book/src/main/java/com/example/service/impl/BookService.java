package com.example.service.impl;

import com.example.model.Book;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAllBook(String name, Pageable pageable) {
        return this.iBookRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void borrowBook(Long id) {
        this.iBookRepository.borrowBook(id);
    }

    @Override
    public Book findById(Long id) {
        return this.iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void giveBookBack(Long id) {
        this.iBookRepository.giveBookBack(id);
    }
}
