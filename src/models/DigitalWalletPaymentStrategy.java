/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.PaymentStrategy;

/**
 *
 * @author acer
 */
// Represents a payment strategy using a digital wallet
public class DigitalWalletPaymentStrategy implements PaymentStrategy{

    @Override
    public boolean processPayment(Order order) {
        return true;
    } 
}
