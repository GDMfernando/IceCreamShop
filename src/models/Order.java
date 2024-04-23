/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import enums.DeliveryMethod;
import enums.OrderStatus;
import interfaces.OrderDecorator;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class Order {
// Properties of the order
    private int orderId;
    private Customer customer;
    private List<IceCream> items;
    private String customizationName;
    private OrderStatus orderStatus;
    private DeliveryMethod deliveryMethod;
    private OrderState currentState;
    private List<OrderDecorator> decorators = new ArrayList<>();
    private double total;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.orderStatus = OrderStatus.PLACED;
        this.deliveryMethod = DeliveryMethod.PICKUP;
        this.currentState = new PlacedOrderState();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<IceCream> getItems() {
        return items;
    }

    public void addItem(IceCream item) {
        items.add(item);
    }

    public void removeItem(IceCream item) {
        items.remove(item);
    }

    // Method to calculate the total cost of the order
    public double calculateTotal() {
        double total = 0.0;
        for (IceCream item : items) {

            total += calculateItemCost(item);
        }
        return total;
    }

    private double calculateItemCost(IceCream item) {
        double flavorCost = item.getFlavor().getPrice();

        double toppingsCost = item.getToppings().stream().mapToDouble(Topping::getPrice).sum();
        double syrupsCost = item.getSyrups().stream().mapToDouble(Syrup::getPrice).sum();

        return flavorCost + toppingsCost + syrupsCost;
    }

    // Method to get the estimated delivery time based on the order status
    public LocalDateTime getDeliveryEstimate() {
        switch (orderStatus) {
            case PLACED:
                return calculatePlacedEstimate();
            case IN_PREPARATION:
                return calculatePreparationEstimate();
            case OUT_FOR_DELIVERY:
                return calculateDeliveryEstimate();
            case DELIVERED:
                return LocalDateTime.now(); // Order already delivered, return current time
            default:
                return null;
        }
    }

    private LocalDateTime calculatePlacedEstimate() {
        return LocalDateTime.now().plusMinutes(30);
    }

    private LocalDateTime calculatePreparationEstimate() {
        return LocalDateTime.now().plusMinutes(20);
    }

    private LocalDateTime calculateDeliveryEstimate() {
        return LocalDateTime.now().plusMinutes(40);
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void updateOrderStatus(OrderStatus newStatus) {
        this.orderStatus = newStatus;
    }

    public void setDeliveryMethod(DeliveryMethod method) {
        this.deliveryMethod = method;
    }

    public Order() {
        this.currentState = new PlacedOrderState();
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }
// Method to process the order based on the current state
    public void processOrder() {
        currentState.processOrder(this);
    }

    public void addDecorator(OrderDecorator decorator) {
        decorators.add(decorator);
    }
    
// Method to apply all decorators to the order
    public void applyDecorations() {
        for (OrderDecorator decorator : decorators) {
            decorator.decorate(this);
        }
    }
}
