package com.codegym.repository;

import com.codegym.model.customer.GuestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuestTypeRepository extends JpaRepository<GuestType,Integer> {
}
