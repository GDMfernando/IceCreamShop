/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

import interfaces.OrderStatusObserver;
import java.util.List;
import java.util.ArrayList;
import models.Order;
/**
 *
 * @author acer
 */
public enum OrderStatus {
    // order statuses
     PLACED, IN_PREPARATION, OUT_FOR_DELIVERY, DELIVERED;
     
     private List<OrderStatusObserver> observers = new ArrayList<>();
     
     public void addObserver(OrderStatusObserver observer) {
        observers.add(observer);
    }
     
    public void notifyObservers(Order order) {
        for (OrderStatusObserver observer : observers) {
            observer.update(order);
        }
    }
    
     public void updateOrderStatus(Order order, OrderStatus newStatus) {
        this.notifyObservers(order); // Notify observers before the status change
        order.setOrderStatus(newStatus);
        this.notifyObservers(order); // Notify observers after the status change
    } 
}
