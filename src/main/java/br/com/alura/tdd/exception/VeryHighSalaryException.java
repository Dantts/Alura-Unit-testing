package br.com.alura.tdd.exception;

public class VeryHighSalaryException extends IllegalArgumentException{
    public VeryHighSalaryException() {
        super("Employee with a high salary to receive bonus.");
    }
}
