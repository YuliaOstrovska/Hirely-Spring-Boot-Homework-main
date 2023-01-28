package pl.hirely.springboot.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.hirely.springboot.company.model.dto.CompanyDto;
import pl.hirely.springboot.company.model.dto.DepartmentDto;
import pl.hirely.springboot.company.model.repository.DepartmentRepository;
import pl.hirely.springboot.company.model.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public CompanyController(CompanyService companyService,
                             DepartmentRepository departmentRepository) {
        this.companyService = companyService;
        this.departmentRepository = departmentRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto) {
        return companyService.addDepartment(departmentDto);
    }

    @GetMapping("/salaries/departments")
    public List<CompanyDto> getDepartmentSalaries() {
        List<CompanyDto> departmentSalaries = companyService.calculateDepartmentSalaries();
        return departmentSalaries;
    }
}

