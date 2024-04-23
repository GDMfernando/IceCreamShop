/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import enums.PaymentMethod;
import interfaces.PaymentStrategy;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author acer
 */
//PaymentProcessor class handles the processing of payments for orders.
public class PaymentProcessor {
//Map to store different payment strategies based on payment methods
    private Map<PaymentMethod, PaymentStrategy> strategies;

    public PaymentProcessor() {
        this.strategies = new HashMap<>();
    }

    public void processPayment(Order order, PaymentMethod method) {
        PaymentStrategy strategy = strategies.get(method);
        if (strategy != null) {
            strategy.processPayment(order);
        } else {
            throw new UnsupportedOperationException("Unsupported payment method: " + method);
        }
    }

    public void addPaymentStrategy(PaymentMethod method, PaymentStrategy strategy) {
        strategies.put(method, strategy);
    }
}
