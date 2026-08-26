package my.exercises.ex02.entities;

import my.exercises.ex02.interfaces.PaymentService;

public class PixService implements PaymentService {
    private final double tax = 0.05;

    @Override
    public void paymentProcess(double amount) {

    }
}
