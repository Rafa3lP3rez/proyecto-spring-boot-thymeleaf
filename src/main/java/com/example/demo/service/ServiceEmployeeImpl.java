package com.example.demo.service;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee{

    EmployeeRepo employee;

    @Autowired
    public ServiceEmployeeImpl(EmployeeRepo employee){
        this.employee = employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employee.findAll();
    }

    @Override
    public Employee getEmploye(int id) {
        return employee.getById(id);
    }

    @Override
    public void save(Employee employee) {
        this.employee.save(employee);
    }

    @Override
    public void delete(int id) {

        //employee.delete(id);

    }
}
