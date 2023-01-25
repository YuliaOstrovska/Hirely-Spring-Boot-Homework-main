package pl.hirely.springboot.company.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cleaner extends BaseEmployee{

    @Override
    public BigDecimal calculateSalary() {
        return getBaseSalary();
    }

    public Cleaner(BigDecimal baseSalary, LocalDate employmentDate) {
        super(baseSalary, employmentDate);
    }
}
