/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import enums.OrderStatus;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class OrderManager {

    private List<Order> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);

        // Process the order using the OrderState pattern
        order.processOrder();
        System.out.println("Order Status: " + order.getOrderStatus());
    }

    public List<Order> getOrders() {
        return orders;
    }

    public OrderStatus trackOrder(int orderId) {
        // Implementation of order tracking

        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order.getOrderStatus();
            }
        }
        return null;
    }

}
