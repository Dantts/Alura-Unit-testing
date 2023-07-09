package br.com.alura.tdd.exception;

public class NotReceivedValidEmployeePerformanceException extends IllegalArgumentException {
    public NotReceivedValidEmployeePerformanceException() {
        super("Method not received a valid employee performance value");
    }
}
