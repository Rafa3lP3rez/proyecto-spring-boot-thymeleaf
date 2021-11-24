package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.ServiceEmployee;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "employee/list-employees";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model){

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employee/employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee){

        serviceEmployee.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("employeeId") int id, Model model){

        Employee employee = serviceEmployee.getEmploye(id);

        model.addAttribute("employee", employee);

        return "employee/employee-form";
    }

}
