package com.paymentsystem.payment.strategy;

import org.springframework.stereotype.Component;

@Component("creditCardPayment")
public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using Credit Card";
    }
}