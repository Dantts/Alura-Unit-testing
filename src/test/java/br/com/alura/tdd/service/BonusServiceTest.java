package br.com.alura.tdd.service;

import br.com.alura.tdd.exception.VeryHighSalaryException;
import br.com.alura.tdd.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusServiceTest {
    private BonusService service;
    private Employee employee;

    @BeforeEach
    public void Initialize() {
        this.service = new BonusService();
        this.employee = new Employee(
                "Gabriel Duarte",
                LocalDate.now(),
                BigDecimal.ZERO
        );
    }

    @Test
    void ShouldBeTenPercentOfSalary() {
        employee.setSalary(new BigDecimal(5000));

        assertEquals(new BigDecimal("500.00"), service.calculateBonus(employee));
    }

    @Test
    void ShouldBeTenPercentOfExactly10ThousandSalary() {
        employee.setSalary(new BigDecimal(10000));

        assertEquals(new BigDecimal("1000.00"), service.calculateBonus(employee));
    }

    @Test
    void ShouldBeExceptionForEmployeeWithVeryHighSalary() {
        employee.setSalary(new BigDecimal(12000));
        assertThrows(
                VeryHighSalaryException.class,
                () -> service.calculateBonus(employee)
        );
    }
}