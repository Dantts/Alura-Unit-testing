package br.com.alura.tdd.service;

import br.com.alura.tdd.exception.NotReceivedValidEmployeePerformanceException;
import br.com.alura.tdd.model.Employee;
import br.com.alura.tdd.model.EmployeePerformanceEnum;

import java.math.BigDecimal;

public class AdjustmentService {

    public void applyAdjustment (Employee employee, EmployeePerformanceEnum employeePerformanceEnum) {
        if(employeePerformanceEnum.adjustmentPercent().equals(BigDecimal.ZERO))
            throw new NotReceivedValidEmployeePerformanceException();

        BigDecimal adjustment = employee.getSalary()
                .multiply(employeePerformanceEnum.adjustmentPercent());

        employee.addAdjustment(adjustment);
    }
}
