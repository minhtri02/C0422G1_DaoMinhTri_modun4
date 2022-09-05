package com.example.service;

import com.example.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    Page<Smartphone> findAll(Pageable pageable);

    Optional<Smartphone> findById(Long id);

    void save(Smartphone smartPhone);

    void remove(Long id);
}
