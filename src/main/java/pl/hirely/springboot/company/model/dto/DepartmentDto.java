package pl.hirely.springboot.company.model.dto;

import pl.hirely.springboot.company.model.domain.Department;
import pl.hirely.springboot.company.model.domain.Employee;

import java.util.List;


public class DepartmentDto {

    private Long id;


    private String name;

    private List<Employee> employees;

    public static Department toEntity(DepartmentDto departmentDto) {
        return new Department(departmentDto.getName(),departmentDto.getEmployees());
    }

    public static DepartmentDto fromEntity(Department department) {
        DepartmentDto departmentDto =
                new DepartmentDto(department.getId(),department.getName(),department.getEmployees());
        return departmentDto;
    }

    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public DepartmentDto(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

