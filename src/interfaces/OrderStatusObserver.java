/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import models.Feedback;
import models.Order;

/**
 *
 * @author acer
 */
//Observer Pattern
public interface OrderStatusObserver {
     void update(Order order);
}

