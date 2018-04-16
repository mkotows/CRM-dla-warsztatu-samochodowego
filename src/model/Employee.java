package model;

import java.math.BigDecimal;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String note;
    private BigDecimal salary_per_hour;
    
    public Employee() {
    }

    public Employee(String name, String surname, String address, String phone, String note, BigDecimal salary_per_hour) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.salary_per_hour = salary_per_hour;
    }

    public Employee(int id, String name, String surname, String address, String phone, String note, BigDecimal salary_per_hour) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.salary_per_hour = salary_per_hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getSalary_per_hour() {
        return salary_per_hour;
    }

    public void setSalary_per_hour(BigDecimal salary_per_hour) {
        this.salary_per_hour = salary_per_hour;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
