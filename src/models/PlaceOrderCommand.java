/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.OrderCommand;

/**
 *
 * @author acer
 */
public class PlaceOrderCommand implements OrderCommand {

    private OrderManager orderManager;
    private Order order;

    public PlaceOrderCommand(OrderManager orderManager, Order order) {
        this.orderManager = orderManager;
        this.order = order;
    }

    @Override
    public void execute() {
        orderManager.placeOrder(order);
    }
}
