package com.saketh.employeeinsertion.service;

import com.saketh.employeeinsertion.dao.IEmployeeDAO;
import com.saketh.employeeinsertion.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeDAO employeeDAO;

    @Override
    public String registerEmployee(Employee emp) throws Exception {
        int result = employeeDAO.addEmployee(emp);
        return result == 0 ? "Employee Not Registered" : "Employee Registered";
    }
}
