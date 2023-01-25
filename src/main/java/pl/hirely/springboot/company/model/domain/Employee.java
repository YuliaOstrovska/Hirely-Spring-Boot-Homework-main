package pl.hirely.springboot.company.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Potrzebne, aby Postgres sam inkrementował klucz główny typu SERIAL (zobacz: V1_0__schema.sql)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "base_salary")
    private BigDecimal baseSalary;

    @Column(name = "employment_date")
    private LocalDate employmentDate;



    public Employee() {
    }

    public Employee(Long id, String fullName,
                    String email, Position position, BigDecimal baseSalary, LocalDate employmentDate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.position = position;
        this.baseSalary = baseSalary;
        this.employmentDate = employmentDate;
    }

    public Employee(Department department,
                    String fullName, String email, Position position, BigDecimal baseSalary, LocalDate employmentDate) {
        this.department = department;
        this.fullName = fullName;
        this.email = email;
        this.position = position;
        this.baseSalary = baseSalary;
        this.employmentDate = employmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
