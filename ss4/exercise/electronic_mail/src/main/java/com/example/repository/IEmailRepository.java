package com.example.repository;

import com.example.model.BoxEmail;

import java.util.List;

public interface IEmailRepository {
    List<String> languages();

    List<String> pageSize();

    BoxEmail displayEmail();

    void updateEmail(BoxEmail  box);
}
