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


    /*public BigDecimal calculateSalary(Employee employee) {
        BigDecimal calculatedSalary = employee.getBaseSalary();

        int experience = LocalDate.now().getYear() - employee.getEmploymentDate().getYear();

        switch (employee.getPosition()) {
            case DIRECTOR -> calculatedSalary.
                    add(calculatedSalary.multiply(BigDecimal.valueOf(0.1 * experience)));

            case DEVELOPER -> calculatedSalary = experience >= 1 ? calculatedSalary.
                    add(calculatedSalary.multiply(BigDecimal.valueOf(1.2))) : calculatedSalary;
        }
        return calculatedSalary;
    }*/

    public BigDecimal calculateSalary(Employee employee) {

        return mapEntityToDoMain(employee).calculateSalary();
    }

    private BaseEmployee mapEntityToDoMain (Employee employee){
        return switch (employee.getPosition()){
            case CLEANER -> new Cleaner(employee.getBaseSalary(), employee.getEmploymentDate());

            case DEVELOPER -> new Cleaner(employee.getBaseSalary(), employee.getEmploymentDate());

            case DIRECTOR -> new Cleaner(employee.getBaseSalary(), employee.getEmploymentDate());
        }
        ;
    }
    public List<CompanyDto> calculateDepartmentSalaries() {
    return departmentRepository.findAll().stream().map(department ->
            new CompanyDto(department.getName(), sumSalary(department.getEmployees()))).toList();
    }

    private BigDecimal sumSalary (List<Employee> employees){
        return employees.stream().map(employee -> calculateSalary(employee))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

   /* public List<CompanyDto> calculateDepartmentSalaries() {
        List<Employee> employees = employeeRepository.findAll();
        Map<String, BigDecimal> departmentSalaries = new HashMap<>();
        employees.stream()
                .forEach(employee -> {
                    BigDecimal salary = calculateSalary(employee);
                    String department = employee.getDepartment().getName();
                    if (departmentSalaries.containsKey(department)) {
                        departmentSalaries.put(department, departmentSalaries.get(department).add(salary));
                    } else {
                        departmentSalaries.put(department, salary);
                    }
                });
        List<CompanyDto> companyDtos = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : departmentSalaries.entrySet()) {
            companyDtos.add(new CompanyDto(entry.getKey(), entry.getValue()));
        }
        return companyDtos;
    }*/

    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department saveDepartment = departmentRepository.save(DepartmentDto.toEntity(departmentDto));
        return DepartmentDto.fromEntity(saveDepartment);
    }

    /*public void sumSalaryByDepartment (Position,) {
        employeeRepository.findAll().stream().map(Employee::getDepartment).c
        employeeRepository.findAll().sort(Employee-);
    }*/


}
