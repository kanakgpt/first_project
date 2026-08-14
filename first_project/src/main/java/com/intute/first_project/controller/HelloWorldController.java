package com.intute.first_project.controller;

import com.intute.first_project.model.Employee;
import org.springframework.web.bind.annotation.*;

//api/hello
@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello")
    public String displayMsg(){
        return "Welcome to Spring Boot!";
    }
    @PostMapping
    public String creatEmploye(@RequestBody Employee employee){
        System.out.println("Creating employee " + employee);
        return "Employee created successfully!";

    }
}
