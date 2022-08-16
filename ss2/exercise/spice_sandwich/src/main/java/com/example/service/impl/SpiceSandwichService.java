package com.example.service.impl;

import com.example.repository.ISpiceSandwichRepository;
import com.example.service.ISpiceSandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpiceSandwichService implements ISpiceSandwichService {

    @Autowired
    private ISpiceSandwichRepository iSpiceSandwichRepository;

    @Override
    public List<String> findAll() {
        return this.iSpiceSandwichRepository.findAll();
    }

    @Override
    public List<String> findSpice(String[] spice) {
        return this.iSpiceSandwichRepository.findSpice(spice);
    }
}
