package com.paymentsystem.payment.strategy;

import org.springframework.stereotype.Component;

@Component("payPalPayment")
public class PayPalPaymentStrategy implements PaymentStrategy {

    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using PayPal";
    }
}
