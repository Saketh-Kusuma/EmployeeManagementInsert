package com.saketh.employeeinsertion.model;

import lombok.Data;

@Data
public final class Employee {
    private Integer empNo;
    private String eName;
    private String job;
    private Double salary;
    private Integer deptNo;
    private Integer grossSalary;
    private Integer netSalary;
}
