package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface ServiceEmployee {

    List<Employee> getEmployees();
    Employee getEmploye(int id);
    void save(Employee employee);
    void delete(int id);
}
