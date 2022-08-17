package com.example.service.impl;

import com.example.model.Medical;
import com.example.repository.IMedicalRepository;
import com.example.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {

    @Autowired
    private IMedicalRepository iMedicalRepository;

    @Override
    public List<String> getListDay() {
        return this.iMedicalRepository.getListDay();
    }

    @Override
    public List<String> getListMonth() {
        return this.iMedicalRepository.getListMonth();
    }

    @Override
    public List<String> getListYear() {
        return this.iMedicalRepository.getListYear();
    }

    @Override
    public List<String> getListNationality() {
        return this.iMedicalRepository.getListNationality();
    }

    @Override
    public List<String> getListTransport() {
        return this.iMedicalRepository.getListTransport();
    }

    @Override
    public Medical searchById(int id) {
        return this.iMedicalRepository.searchById(id);
    }

    @Override
    public void saveMedical(Medical medical) {
        this.iMedicalRepository.saveMedical(medical);
    }

    @Override
    public List<Medical> findAll() {
        return this.iMedicalRepository.findAll();
    }

    @Override
    public void update(int id, Medical medical) {
        this.iMedicalRepository.update(id, medical);
    }
}
