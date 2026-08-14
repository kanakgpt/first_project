package com.intute.first_project.model;

import lombok.Data;

@Data
public class Employee  {
    private String name;
    private String age;
    private double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name=>>>>>>>>>>>'" + name + '\'' +
                ", age=>>>>>'" + age + '\'' +
                ", salary=>>>>>>>" + salary +
                '}';
    }
}

//config
//util
//repo
//exception
//
