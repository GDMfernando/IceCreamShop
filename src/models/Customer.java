/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.OrderStatusObserver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class Customer implements OrderStatusObserver{
    private int customerId;
    private String customerName;
    private List<Order> favorites;
    private int loyaltyPoints;

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.favorites = new ArrayList<>();
        this.loyaltyPoints = 0;
    }
    
     public void addToFavorites(Order order) {
        favorites.add(order);
    }

    public List<Order> getFavorites() {
        return favorites;
    }

    // Get the loyalty points of the customer
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

     // Increase loyalty points by a specified amount
    public void increaseLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    } 
    
        @Override
    public void update(Order order) {
        // Notify the customer about order status changes
        System.out.println("Order status updated: " + order.getOrderStatus());
    }
}