package com.example.service;

import com.example.model.Medical;

import java.util.List;

public interface IMedicalService {
    List<String> getListDay();

    List<String> getListMonth();

    List<String> getListYear();

    List<String> getListNationality();

    List<String> getListTransport();

    public Medical searchById(int id);

    public void saveMedical(Medical medical);

    public List<Medical> findAll();

    public void update(int id, Medical medical);

}
