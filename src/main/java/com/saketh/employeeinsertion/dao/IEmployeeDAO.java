package com.saketh.employeeinsertion.dao;

import com.saketh.employeeinsertion.model.Employee;

public interface IEmployeeDAO {
    public int addEmployee(Employee emp) throws Exception;
}
