package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
    private int id;
    private LocalDate date;
    private LocalDate planing_date;
    private LocalDate end_date;
    private int employee_id;
    private String problem_description;
    private String repair_description;
    private String status;
    private int vehicle_id;
    private BigDecimal total_cost;
    private BigDecimal elements_cost;
    private BigDecimal hour_cost;
    private BigDecimal repair_hours;

    public Order() {
    }

    public Order(LocalDate date, LocalDate planing_date, LocalDate end_date, int employee_id,
                 String problem_description, String repair_description, String status, int vehicle_id,
                 BigDecimal total_cost, BigDecimal elements_cost, BigDecimal hour_cost, BigDecimal repair_hours) {
        this.date = date;
        this.planing_date = planing_date;
        this.end_date = end_date;
        this.employee_id = employee_id;
        this.problem_description = problem_description;
        this.repair_description = repair_description;
        this.status = status;
        this.vehicle_id = vehicle_id;
        this.total_cost = total_cost;
        this.elements_cost = elements_cost;
        this.hour_cost = hour_cost;
        this.repair_hours = repair_hours;
    }

    public Order(int id, LocalDate date, LocalDate planing_date, LocalDate end_date, int employee_id,
                 String problem_description, String repair_description, String status, int vehicle_id,
                 BigDecimal total_cost, BigDecimal elements_cost, BigDecimal hour_cost, BigDecimal repair_hours) {
        this.id = id;
        this.date = date;
        this.planing_date = planing_date;
        this.end_date = end_date;
        this.employee_id = employee_id;
        this.problem_description = problem_description;
        this.repair_description = repair_description;
        this.status = status;
        this.vehicle_id = vehicle_id;
        this.total_cost = total_cost;
        this.elements_cost = elements_cost;
        this.hour_cost = hour_cost;
        this.repair_hours = repair_hours;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getPlaning_date() {
        return planing_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getProblem_description() {
        return problem_description;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public String getStatus() {
        return status;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public BigDecimal getTotal_cost() {
        return total_cost;
    }

    public BigDecimal getElements_cost() {
        return elements_cost;
    }

    public BigDecimal getHour_cost() {
        return hour_cost;
    }

    public BigDecimal getRepair_hours() {
        return repair_hours;
    }

    @Override
    public String toString() {
        return date + ": " + problem_description;
    }
}
