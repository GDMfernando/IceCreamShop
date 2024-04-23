/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author acer
 */
// Chain of Responsibility Pattern
abstract class IceCreamHandler {

    private IceCreamHandler nextHandler;

    protected IceCreamHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(IceCreamHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(OrderBuilder orderBuilder);
}

class ToppingHandler extends IceCreamHandler {

    @Override
    public void handleRequest(OrderBuilder orderBuilder) {
        // Handle topping customization
        // If not handled, pass to the next handler
        if (getNextHandler() != null) {
            getNextHandler().handleRequest(orderBuilder);
        }
    }
}

class FlavorHandler extends IceCreamHandler {

    @Override
    public void handleRequest(OrderBuilder orderBuilder) {
        // Handle flavor customization
        // If not handled, pass to the next handler
        if (getNextHandler() != null) {
            getNextHandler().handleRequest(orderBuilder);
        }
    }
}

class SyrupHandler extends IceCreamHandler {

    @Override
    public void handleRequest(OrderBuilder orderBuilder) {
        // Handle syrup customization
        // If not handled, pass to the next handler
        if (getNextHandler() != null) {
            getNextHandler().handleRequest(orderBuilder);
        }
    }
}
