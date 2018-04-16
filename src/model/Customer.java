package model;


import java.time.LocalDate;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private LocalDate birth_date;

    public Customer() {
    }

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Customer(String name, String surname, LocalDate birth_date) {
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
    }

    public Customer(int id, String name, String surname) {
        this.id=id;
        this.name = name;
        this.surname = surname;
    }

    public Customer(int id, String name, String surname, LocalDate birth_date) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
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

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " " + surname +" " +(birth_date==null?"":birth_date);
    }
}
