package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAllBook(String name, Pageable pageable);

    void borrowBook(Long id);

    Book findById(Long id);

    void giveBookBack(Long id);
}
