package com.codegym.service;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(String keyWord, Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Integer id);
}
