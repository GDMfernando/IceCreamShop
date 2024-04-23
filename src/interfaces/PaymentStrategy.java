/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import models.Order;

/**
 *
 * @author acer
 */
//Strategy Pattern
public interface PaymentStrategy {
    boolean processPayment(Order order); 
}