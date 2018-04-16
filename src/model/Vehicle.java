package model;

import java.time.LocalDate;

public class Vehicle {
    private int id;
    private String model;
    private String brand;
    private String production_year;
    private String number;
    private LocalDate next_service;
    private int client_id;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, String production_year, String number, LocalDate next_service, int client_id) {
        this.model = model;
        this.brand = brand;
        this.production_year = production_year;
        this.number = number;
        this.next_service = next_service;
        this.client_id = client_id;
    }

    public Vehicle(int id, String model, String brand, String production_year, String number, LocalDate next_service, int client_id) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.production_year = production_year;
        this.number = number;
        this.next_service = next_service;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduction_year() {
        return production_year;
    }

    public void setProduction_year(String production_year) {
        this.production_year = production_year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getNext_service() {
        return next_service;
    }

    public void setNext_service(LocalDate next_service) {
        this.next_service = next_service;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return brand +" " + model;
    }
}
