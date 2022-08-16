package com.example.repository.impl;

import com.example.repository.ISpiceSandwichRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpiceSandwichRepository implements ISpiceSandwichRepository {

    private static List<String> list = new ArrayList<>();

    static {
        list.add("Lettuce");
        list.add("Tomato");
        list.add("Mustard");
        list.add("Sprouts");
    }

    @Override
    public List<String> findAll() {
        return list;
    }

    @Override
    public List<String> findSpice(String[] spice) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < spice.length; i++) {
            stringList.add(spice[i]);
        }
        return stringList;
    }
}
