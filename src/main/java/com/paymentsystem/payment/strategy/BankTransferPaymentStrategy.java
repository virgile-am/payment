package com.paymentsystem.payment.strategy;

import org.springframework.stereotype.Component;

@Component("bankTransferPayment")
public class BankTransferPaymentStrategy implements PaymentStrategy {

    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using Bank Transfer";
    }
}