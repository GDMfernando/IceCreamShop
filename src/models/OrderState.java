/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models;

import enums.OrderStatus;
import models.Order;

/**
 *
 * @author acer
 */
// State Pattern
public interface OrderState {

    void processOrder(Order order);
}

class DeliveredOrderState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("Order is delivered. Thank you for shopping!");
        order.updateOrderStatus(OrderStatus.DELIVERED);
    }
}

class InPreparationOrderState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("Order is in preparation. Please wait for it to be ready.");
        order.updateOrderStatus(OrderStatus.IN_PREPARATION);

    }
}

class OutForDeliveryOrderState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("Order is out for delivery. Expect it soon!");
        order.updateOrderStatus(OrderStatus.OUT_FOR_DELIVERY);
    }
}

class PlacedOrderState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("Order is placed. Processing your request.");
        order.updateOrderStatus(OrderStatus.PLACED);
    }
}
