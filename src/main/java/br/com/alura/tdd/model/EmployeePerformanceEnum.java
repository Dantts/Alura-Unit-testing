package br.com.alura.tdd.model;

import java.math.BigDecimal;

public enum EmployeePerformanceEnum {
    DESIRED {
        @Override
        public BigDecimal adjustmentPercent() {
            return BigDecimal.ZERO;
        }
    },

    NOTGOOD {
        @Override
        public BigDecimal adjustmentPercent() {
            return new BigDecimal("0.03") ;
        }
    },

    GOOD {
        @Override
        public BigDecimal adjustmentPercent() {
            return new BigDecimal("0.15");
        }
    },

    EXCELLENT {
        @Override
        public BigDecimal adjustmentPercent() {
            return new BigDecimal("0.20");
        }
    };

    public abstract BigDecimal adjustmentPercent();
}
