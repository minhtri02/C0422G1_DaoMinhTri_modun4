package com.codegym.service.guest_type_impl;

import com.codegym.model.customer.GuestType;
import com.codegym.repository.IGuestTypeRepository;
import com.codegym.service.IGuestTypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestTypeCustomerImpl implements IGuestTypeCustomerService {

    @Autowired
    private IGuestTypeRepository iGuestTypeRepository;

    @Override
    public List<GuestType> findAll() {
        return this.iGuestTypeRepository.findAll();
    }
}
