package com.paymentsystem.payment.controller;

import com.paymentsystem.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{method}")
    public String makePayment(@PathVariable String method, @RequestParam double amount) {
        switch (method) {
            case "creditCard":
                paymentService.setPaymentStrategy(paymentService.getStrategy("creditCardPayment"));
                break;
            case "payPal":
                paymentService.setPaymentStrategy(paymentService.getStrategy("payPalPayment"));
                break;
            case "bankTransfer":
                paymentService.setPaymentStrategy(paymentService.getStrategy("bankTransferPayment"));
                break;
            default:
                return "Invalid payment method!";
        }
        return paymentService.processPayment(amount);
    }
}
