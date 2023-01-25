package pl.hirely.springboot.company.model.dto;

import pl.hirely.springboot.company.model.domain.Employee;
import pl.hirely.springboot.company.model.domain.Position;

import java.math.BigDecimal;
import java.time.LocalDate;


public class EmployeeDto {

    private Long id;

    private String fullName;

    private String email;

    private Position position;

    private BigDecimal baseSalary;

    private LocalDate employmentDate;
    public static Employee toEntity(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(), employeeDto.getFullName(), employeeDto.getEmail(),
                employeeDto.getPosition(),employeeDto.baseSalary,employeeDto.getEmploymentDate());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }
}
