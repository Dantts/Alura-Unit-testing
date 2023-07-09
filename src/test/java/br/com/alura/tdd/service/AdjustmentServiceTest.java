package br.com.alura.tdd.service;

import br.com.alura.tdd.exception.NotReceivedValidEmployeePerformanceException;
import br.com.alura.tdd.model.Employee;
import br.com.alura.tdd.model.EmployeePerformanceEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdjustmentServiceTest {
    private AdjustmentService service;
    private Employee employee;

    @BeforeEach
    public void Initialize() {
        this.service = new AdjustmentService();
        this.employee = new Employee(
                "Gabriel Duarte",
                LocalDate.now(),
                new BigDecimal("1000.00")
            );
    }

    @Test
    void ShouldBeAdjustmentOfThreePercentWhenPerformanceIsToBeNotGood () {
        service.applyAdjustment(employee, EmployeePerformanceEnum.NOTGOOD);

        assertEquals(new BigDecimal("1030.00"), employee.getSalary());
    }

    @Test
    void ShouldBeAdjustmentOfFiveTenPercentWhenPerformanceIsToBeGood () {
        service.applyAdjustment(employee, EmployeePerformanceEnum.GOOD);

        assertEquals(new BigDecimal("1150.00"), employee.getSalary());
    }

    @Test
    void ShouldBeAdjustmentOfTwentyPercentWhenPerformanceIsToBeExcellent () {
        service.applyAdjustment(employee, EmployeePerformanceEnum.EXCELLENT);

        assertEquals(new BigDecimal("1200.00"), employee.getSalary());
    }

    @Test
    void ShouldBeExceptionWhenNotReceivedAValidEmployeePerformanceValue () {
        assertThrows(
                NotReceivedValidEmployeePerformanceException.class,
                () -> service.applyAdjustment(employee, EmployeePerformanceEnum.DESIRED)
        );
    }

}
