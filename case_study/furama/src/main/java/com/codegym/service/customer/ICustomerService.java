package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(String keyWord, Pageable pageable);

    Page<Customer> findAll( Pageable pageable);

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Integer id);
}
