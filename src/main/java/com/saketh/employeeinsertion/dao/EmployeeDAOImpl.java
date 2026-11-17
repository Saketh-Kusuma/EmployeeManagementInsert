package com.saketh.employeeinsertion.dao;

import com.saketh.employeeinsertion.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
    @Autowired
    private DataSource dataSource;
    private final String INSERT_EMPLOYEES = "INSERT INTO EMPLOYEES (ENAME, JOB, SALARY, DEPTNO) " + "VALUES (?,?,?,?)";

    @Override
    public int addEmployee(Employee emp) throws Exception {
        int result = 0;
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEES);
        ) {
            ps.setString(1, emp.getEName());
            ps.setString(2, emp.getJob());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getDeptNo());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}
