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
public class ProvideFeedbackCommand implements OrderCommand {

    private FeedbackManager feedbackManager;
    private Order order;
    private Feedback feedback;

    public ProvideFeedbackCommand(FeedbackManager feedbackManager, Order order, Feedback feedback) {
        this.feedbackManager = feedbackManager;
        this.order = order;
        this.feedback = feedback;
    }

    @Override
    public void execute() {
        feedbackManager.provideFeedback(order, feedback);
    }
}
