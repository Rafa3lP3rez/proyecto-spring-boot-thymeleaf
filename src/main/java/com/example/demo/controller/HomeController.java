package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class HomeController {

    private ServiceEmployee serviceEmployee;

    @Autowired
    public HomeController(ServiceEmployee serviceEmployee){
        this.serviceEmployee = serviceEmployee;
    }


    @GetMapping("/list")
    public String getEmployees(Model model) {

        List<Employee> list = serviceEmployee.getEmployees();

        model.addAttribute("employees", list);
        return "list-employees";
    }


}
