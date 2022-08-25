package com.example.register_form.service.impl;

import com.example.register_form.model.User;
import com.example.register_form.repository.IUserRepository;
import com.example.register_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return this.iUserRepository.findAll();
    }

    @Override
    public void add(User user) {
        this.iUserRepository.save(user);
    }
}
