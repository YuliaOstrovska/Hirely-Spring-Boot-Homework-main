package pl.hirely.springboot.company.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Director extends BaseEmployee {
    @Override
    public BigDecimal calculateSalary() {
        return getBaseSalary().add(calculateBonus());
    }
    private BigDecimal calculateBonus (){
        return getBaseSalary().multiply(BigDecimal.valueOf(0.1).multiply(BigDecimal.valueOf(getExperience())));

    }

    public Director(BigDecimal baseSalary, LocalDate employmentDate) {
        super(baseSalary, employmentDate);
    }

}
