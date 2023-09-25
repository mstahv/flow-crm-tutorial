package com.example.application.data.entity;

import jakarta.validation.constraints.NotBlank;

import java.util.LinkedList;
import java.util.List;

public class Company {
    @NotBlank
    private String name;

    private List<Contact> employees = new LinkedList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Contact> employees) {
        this.employees = employees;
    }

    public int getEmployeeCount(){
        return employees.size();
    }
}
