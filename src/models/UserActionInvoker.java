/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.OrderCommand;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class UserActionInvoker {

    private List<OrderCommand> commandQueue = new ArrayList<>();

    public void addToQueue(OrderCommand command) {
        commandQueue.add(command);
    }

    public void processCommands() {
        for (OrderCommand command : commandQueue) {
            command.execute();
        }
        commandQueue.clear();
    }
}
