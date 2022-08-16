package com.example.repository;

import java.util.List;

public interface ISpiceSandwichRepository {
    List<String> findAll();

    List<String> findSpice(String[] spice);
}
