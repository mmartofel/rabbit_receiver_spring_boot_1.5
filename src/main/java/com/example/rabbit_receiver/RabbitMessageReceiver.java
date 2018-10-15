package com.example.rabbit_receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by mmartofel on 10/15/18.
 */

@RabbitListener(queues = "rav.data.amq")
public class RabbitMessageReceiver {

    @RabbitHandler
    public void receiveMessage(String inputMessage) {
        System.out.println("Received message: " + inputMessage);
    }
}
