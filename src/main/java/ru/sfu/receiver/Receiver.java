package ru.sfu.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues = "student-queue", containerFactory =
            "rabbitListenerContainerFactory")
    public void listen(String message) {
        System.out.println("Was get message " + message);
    }
}
