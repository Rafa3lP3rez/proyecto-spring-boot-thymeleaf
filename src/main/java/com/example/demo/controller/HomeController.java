package com.example.demo.controller;

import com.example.demo.entity.Employee;
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


    List<Employee> list;

    @PostConstruct
    public void loadData() {

        Employee employee1 = new Employee(1, "Rafael", "Pérez", "alberto98214@gmail.com");
        Employee employee2 = new Employee(1, "Ashley", "Rodriguez", "ashley9414@gmail.com");
        Employee employee3 = new Employee(1, "Jose", "Juarez", "juarez4414@gmail.com");

        list = new ArrayList<>();

        list.add(employee1);
        list.add(employee2);
        list.add(employee3);


    }

    @GetMapping("/list")
    public String getEmployees(Model model) {

        model.addAttribute("employees", list);
        return "list-employees";
    }


}
