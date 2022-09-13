package com.codegym.repository.customer;

import com.codegym.model.customer.GuestType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IGuestTypeRepository extends JpaRepository<GuestType,Integer> {
}
