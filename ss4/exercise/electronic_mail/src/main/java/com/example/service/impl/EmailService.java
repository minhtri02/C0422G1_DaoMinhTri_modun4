package com.example.service.impl;

import com.example.model.BoxEmail;
import com.example.repository.IEmailRepository;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<String> languages() {
        return this.iEmailRepository.languages();
    }

    @Override
    public List<String> pageSize() {
        return this.iEmailRepository.pageSize();
    }

    @Override
    public BoxEmail displayEmail() {
        return this.iEmailRepository.displayEmail();
    }

    @Override
    public void updateEmail(BoxEmail box) {
        this.iEmailRepository.updateEmail(box);
    }
}
