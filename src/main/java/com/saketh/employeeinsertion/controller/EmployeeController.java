package com.saketh.employeeinsertion.controller;

import com.saketh.employeeinsertion.model.Employee;
import com.saketh.employeeinsertion.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> processEmployee(@RequestBody Employee emp) {
        try {
            String result = employeeService.registerEmployee(emp);
            return ResponseEntity.ok(result);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Something went wrong" + e.getMessage());
        }
    }
}
