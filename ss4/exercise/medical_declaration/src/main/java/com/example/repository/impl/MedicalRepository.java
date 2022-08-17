package com.example.repository.impl;

import com.example.model.Medical;
import com.example.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepository implements IMedicalRepository {

    private static List<String> day = new ArrayList<>();
    private static List<String> month = new ArrayList<>();
    private static List<String> year = new ArrayList<>();
    private static List<String> nationality = new ArrayList<>();
    private static List<String> transport = new ArrayList<>();
    private static List<Medical> medicalDeclarationList = new ArrayList<>();

    static {
        for (int i = 1; i < 32; i++) {
            day.add(String.valueOf(i));
        }

        for (int i = 1; i < 13; i++) {
            month.add(String.valueOf(i));
        }

        for (int i = 1990; i < 2022; i++) {
            year.add(String.valueOf(i));
        }

        nationality.add("Việt Nam");
        nationality.add("China");
        nationality.add("laos");
        nationality.add("Cambodia");

        transport.add("Tàu bay");
        transport.add("Tàu thuyền");
        transport.add("Ô tô");
    }


    @Override
    public List<String> getListDay() {
        return day;
    }

    @Override
    public List<String> getListMonth() {
        return month;
    }

    @Override
    public List<String> getListYear() {
        return year;
    }

    @Override
    public List<String> getListNationality() {
        return nationality;
    }

    @Override
    public List<String> getListTransport() {
        return transport;
    }

    @Override
    public Medical searchById(int id) {
        for (Medical medical : medicalDeclarationList) {
            if (medical.getId() == id) {
                return medical;
            }
        }
        return null;
    }

    @Override
    public void saveMedical(Medical medical) {
        int id = (int) Math.floor(Math.random() * 1000);
        medicalDeclarationList.add(new Medical(id, medical.getName(), medical.getYearOfBirt(), medical.getGender(),
                medical.getNationality(), medical.getIdCard(), medical.getTransport(), medical.getIdVehicle(),
                medical.getIdSeat(), medical.getDayStart(), medical.getMonthStart(), medical.getYearStart(),
                medical.getDayEnd(), medical.getMonthEnd(), medical.getYearEnd(), medical.getCity()));
    }

    @Override
    public List<Medical> findAll() {
        return medicalDeclarationList;
    }

    @Override
    public void update(int id, Medical medical) {
        for (Medical medicalDeclaration : medicalDeclarationList) {
            if (medicalDeclaration.getId() == id) {
                medicalDeclaration.setName(medicalDeclaration.getName());
                medicalDeclaration.setCity(medicalDeclaration.getCity());
                medicalDeclaration.setGender(medicalDeclaration.getGender());
                medicalDeclaration.setIdCard(medicalDeclaration.getIdCard());
                medicalDeclaration.setTransport(medicalDeclaration.getTransport());
                medicalDeclaration.setIdSeat(medicalDeclaration.getIdSeat());
                medicalDeclaration.setCity(medicalDeclaration.getCity());
                medicalDeclaration.setIdVehicle(medicalDeclaration.getIdVehicle());
                medicalDeclaration.setDayEnd(medicalDeclaration.getDayEnd());
                medicalDeclaration.setMonthEnd(medicalDeclaration.getMonthEnd());
                medicalDeclaration.setYearEnd(medicalDeclaration.getYearEnd());
                medicalDeclaration.setDayStart(medicalDeclaration.getDayStart());
                medicalDeclaration.setMonthStart(medicalDeclaration.getMonthStart());
                medicalDeclaration.setYearStart(medicalDeclaration.getYearStart());
                medicalDeclaration.setNationality(medicalDeclaration.getNationality());
            }
        }
    }
}
