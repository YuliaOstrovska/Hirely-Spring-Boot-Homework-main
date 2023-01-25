package pl.hirely.springboot.company.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Director extends BaseEmployee{
    @Override
    public BigDecimal calculateSalary() {
        int experience = LocalDate.now().getYear() - getEmploymentDate().getYear();
        return getBaseSalary().multiply(BigDecimal.valueOf(0.1 * experience));
    }

    public Director(BigDecimal baseSalary, LocalDate employmentDate) {
        super(baseSalary, employmentDate);
    }

}
