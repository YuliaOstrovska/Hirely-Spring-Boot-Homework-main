package pl.hirely.springboot.company.model.dto;

import pl.hirely.springboot.company.model.domain.Department;

import java.math.BigDecimal;

public class CompanyDto {

    private String departmentName;

    private BigDecimal sumSalaryAllEmployeeByDepartment;

    public CompanyDto() {
    }

    public CompanyDto(String departmentName, BigDecimal sumSalaryAllEmployeeByDepartment) {
        this.departmentName = departmentName;
        this.sumSalaryAllEmployeeByDepartment = sumSalaryAllEmployeeByDepartment;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public BigDecimal getSumSalaryAllEmployeeByDepartment() {
        return sumSalaryAllEmployeeByDepartment;
    }

    public void setSumSalaryAllEmployeeByDepartment(BigDecimal sumSalaryAllEmployeeByDepartment) {
        this.sumSalaryAllEmployeeByDepartment = sumSalaryAllEmployeeByDepartment;
    }
}
