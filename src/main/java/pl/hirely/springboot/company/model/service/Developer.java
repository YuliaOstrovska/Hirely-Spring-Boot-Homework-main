package pl.hirely.springboot.company.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Developer extends BaseEmployee{

    @Override
    public BigDecimal calculateSalary() {
        int experience = LocalDate.now().getYear() - getEmploymentDate().getYear();
        BigDecimal salary = experience >= 1 ? getBaseSalary().
                add(getBaseSalary().multiply(BigDecimal.valueOf(1.2))) : getBaseSalary();
        return salary;
    }

    public Developer(BigDecimal baseSalary, LocalDate employmentDate) {
        super(baseSalary, employmentDate);
    }
}
