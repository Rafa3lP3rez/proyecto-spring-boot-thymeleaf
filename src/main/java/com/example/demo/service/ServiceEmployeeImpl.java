package com.example.demo.service;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


        Optional<Employee> byId = employee.findById(id);

        Employee employee = null;

        if (byId.isPresent()){
            employee = byId.get();
        } else {
            throw new RuntimeException("El empleado no existe");
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        this.employee.save(employee);
    }

    @Override
    public void delete(int id) {

        employee.deleteById(id);

    }
}
