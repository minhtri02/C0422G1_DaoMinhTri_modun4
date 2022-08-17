package com.example.model;

public class Medical {
    private int id;
    private String name;
    private String yearOfBirt;
    private String gender;
    private String nationality;
    private String idCard;
    private String transport;
    private String idVehicle;
    private String idSeat;
    private String dayStart;
    private String monthStart;
    private String yearStart;
    private String dayEnd;
    private String monthEnd;
    private String yearEnd;
    private String city;

    public Medical() {
    }

    public Medical(int id, String name, String yearOfBirt, String gender, String nationality, String idCard, String transport, String idVehicle, String idSeat, String dayStart, String monthStart, String yearStart, String dayEnd, String monthEnd, String yearEnd, String city) {
        this.id = id;
        this.name = name;
        this.yearOfBirt = yearOfBirt;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.transport = transport;
        this.idVehicle = idVehicle;
        this.idSeat = idSeat;
        this.dayStart = dayStart;
        this.monthStart = monthStart;
        this.yearStart = yearStart;
        this.dayEnd = dayEnd;
        this.monthEnd = monthEnd;
        this.yearEnd = yearEnd;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medical(String name, String yearOfBirt, String gender, String nationality, String idCard, String transport, String idVehicle, String idSeat, String dayStart, String monthStart, String yearStart, String dayEnd, String monthEnd, String yearEnd, String city) {
        this.name = name;
        this.yearOfBirt = yearOfBirt;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.transport = transport;
        this.idVehicle = idVehicle;
        this.idSeat = idSeat;
        this.dayStart = dayStart;
        this.monthStart = monthStart;
        this.yearStart = yearStart;
        this.dayEnd = dayEnd;
        this.monthEnd = monthEnd;
        this.yearEnd = yearEnd;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirt() {
        return yearOfBirt;
    }

    public void setYearOfBirt(String yearOfBirt) {
        this.yearOfBirt = yearOfBirt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(String idSeat) {
        this.idSeat = idSeat;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(String monthStart) {
        this.monthStart = monthStart;
    }

    public String getYearStart() {
        return yearStart;
    }

    public void setYearStart(String yearStart) {
        this.yearStart = yearStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(String monthEnd) {
        this.monthEnd = monthEnd;
    }

    public String getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(String yearEnd) {
        this.yearEnd = yearEnd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
