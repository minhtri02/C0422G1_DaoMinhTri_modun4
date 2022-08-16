package com.example.service;

import java.util.List;

public interface ISpiceSandwichService {
    List<String> findAll();

    List<String> findSpice(String[] spice);
}
