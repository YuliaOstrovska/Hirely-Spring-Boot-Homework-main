package pl.hirely.springboot.company.model.service

import pl.hirely.springboot.company.model.domain.Department
import pl.hirely.springboot.company.model.domain.Employee
import pl.hirely.springboot.company.model.domain.Position
import pl.hirely.springboot.company.model.repository.DepartmentRepository
import pl.hirely.springboot.company.model.repository.EmployeeRepository
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate

class CompanyServiceSpec extends Specification {
    private EmployeeRepository employeeRepository = Mock()
    private DepartmentRepository departmentRepository = Mock()

    @Subject
    private CompanyService companyService = new CompanyService(employeeRepository, departmentRepository)

    def "should return empty list when no department found"() {
        given:
        departmentRepository.findAll()>>List.of()

        when:
        def actual = companyService.calculateDepartmentSalaries()

        then:
        actual.isEmpty()

    }
    def "should return properly calculated salaries"(){
        given:
        Employee developer = new Employee(position: Position.DEVELOPER,
                baseSalary: BigDecimal.valueOf(1000),
                employmentDate: LocalDate.now().minusYears(3))//1200
        Employee director = new Employee(position: Position.DIRECTOR,
                baseSalary: BigDecimal.valueOf(2000),
                employmentDate: LocalDate.now().minusYears(3))//2600
        Employee cleaner = new Employee(position: Position.CLEANER,
                baseSalary: BigDecimal.valueOf(500),
                employmentDate: LocalDate.now().minusYears(3))//500
        Department department = new Department("it", List.of(developer,director,cleaner))

        departmentRepository.findAll()>>List.of(department)

        when:
        def actual = companyService.calculateDepartmentSalaries()

        then:
        actual*.departmentName == ["it"]
        actual*.sumSalaryAllEmployeeByDepartment == [BigDecimal.valueOf(4300)]

    }

}
