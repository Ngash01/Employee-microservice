package com.ngash.microservices.employeeService.controller;

import com.ngash.microservices.employeeService.entity.Employee;
import com.ngash.microservices.employeeService.model.EmployeeMapper;
import com.ngash.microservices.employeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeMapper> getEmployeeDetails(@PathVariable("id") int id){
        System.out.println("EmployeeDetails being called here!");
        return employeeService.getEmployee(id);
    }
}






