package pl.hirely.springboot.company.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public abstract class BaseEmployee {

    private BigDecimal baseSalary;
    private LocalDate employmentDate;

    public BaseEmployee(BigDecimal baseSalary, LocalDate employmentDate) {
        this.baseSalary = baseSalary;
        this.employmentDate = employmentDate;
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

    public abstract BigDecimal calculateSalary ();
    public int getExperience (){
        return Period.between(employmentDate, LocalDate.now()).getYears();
    }
}
