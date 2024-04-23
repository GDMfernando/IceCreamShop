/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.OrderDecorator;

/**
 *
 * @author acer
 */
public class SpecialPackagingDecorator implements OrderDecorator {

    @Override
    public void decorate(Order order) {
        System.out.println("Special packaging added to order #" + order.getOrderId());
    }
}
