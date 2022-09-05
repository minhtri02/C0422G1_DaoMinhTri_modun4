package com.codegym.service.customer;

import com.codegym.model.customer.GuestType;

import java.util.List;

public interface IGuestTypeCustomerService {
    List<GuestType> findAll();
}
