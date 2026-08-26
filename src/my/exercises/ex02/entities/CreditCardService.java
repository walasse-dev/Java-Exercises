package my.exercises.ex02.entities;

import my.exercises.ex02.interfaces.PaymentService;

public class CreditCardService implements PaymentService {
    private final double tax = 0.02;

    @Override
    public void paymentProcess(double amount) {
        double amountWithTax = amount * (1 + tax);
    }
}
