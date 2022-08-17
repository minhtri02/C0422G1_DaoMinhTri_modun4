package com.example.service;

import com.example.model.BoxEmail;

import java.util.List;

public interface IEmailService {
    List<String> languages();

    List<String> pageSize();

    BoxEmail displayEmail();

    void updateEmail(BoxEmail  box);
}
