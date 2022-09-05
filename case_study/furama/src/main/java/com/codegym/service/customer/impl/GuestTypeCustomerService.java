package com.codegym.service.customer.impl;

import com.codegym.model.customer.GuestType;
import com.codegym.repository.customer.IGuestTypeRepository;
import com.codegym.service.customer.IGuestTypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestTypeCustomerService implements IGuestTypeCustomerService {

    @Autowired
    private IGuestTypeRepository iGuestTypeRepository;

    @Override
    public List<GuestType> findAll() {
        return this.iGuestTypeRepository.findAll();
    }
}
