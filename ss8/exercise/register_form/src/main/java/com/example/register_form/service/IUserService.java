package com.example.register_form.service;

import com.example.register_form.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void add(User user);
}
