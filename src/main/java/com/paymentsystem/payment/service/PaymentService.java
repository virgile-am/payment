package com.paymentsystem.payment.service;

import com.paymentsystem.payment.strategy.PaymentStrategy;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final ApplicationContext context;

    // Add the missing field
    @Setter
    private PaymentStrategy paymentStrategy;

    @Autowired
    public PaymentService(ApplicationContext context) {
        this.context = context;
    }

    public PaymentStrategy getStrategy(String strategyName) {
        return context.getBean(strategyName, PaymentStrategy.class);
    }

    public String processPayment(double amount) {
        // Make sure the paymentStrategy is set before calling this method
        if (paymentStrategy == null) {
            throw new IllegalStateException("PaymentStrategy not set");
        }
        return paymentStrategy.pay(amount);
    }
}
