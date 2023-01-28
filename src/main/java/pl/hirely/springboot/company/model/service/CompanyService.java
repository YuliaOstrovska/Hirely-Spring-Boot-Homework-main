package pl.hirely.springboot.company.model.service;

import org.springframework.stereotype.Service;
import pl.hirely.springboot.company.model.domain.Department;
import pl.hirely.springboot.company.model.dto.CompanyDto;
import pl.hirely.springboot.company.model.repository.DepartmentRepository;
import pl.hirely.springboot.company.model.domain.Employee;
import pl.hirely.springboot.company.model.dto.DepartmentDto;
import pl.hirely.springboot.company.model.repository.EmployeeRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public CompanyService(EmployeeRepository employeeRepository,
                          DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department saveDepartment = departmentRepository.save(DepartmentDto.toEntity(departmentDto));
        return DepartmentDto.fromEntity(saveDepartment);
    }



    public List<CompanyDto> calculateDepartmentSalaries() {
        return departmentRepository.findAll().stream().map(department ->
                new CompanyDto(department.getName(), sumSalary(department.getEmployees()))).toList();
    }

    private BigDecimal sumSalary(List<Employee> employees) {
        return employees.stream().map(employee -> calculateSalary(employee))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public BigDecimal calculateSalary(Employee employee) {
        return mapEntityToDoMain(employee).calculateSalary();
    }
    private BaseEmployee mapEntityToDoMain(Employee employee) {
        return switch (employee.getPosition()) {
            case CLEANER -> new Cleaner(employee.getBaseSalary(), employee.getEmploymentDate());

            case DEVELOPER -> new Developer(employee.getBaseSalary(), employee.getEmploymentDate());

            case DIRECTOR -> new Director(employee.getBaseSalary(), employee.getEmploymentDate());
        }
                ;
    }


}
