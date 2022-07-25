package com.parodix.SimpleMicroservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Runner {

  private final RabbitTemplate rabbitTemplate;

  public Runner(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void eventListener() {
    System.out.println("SENDING MESSAGE...");
    rabbitTemplate.convertAndSend("credit-user-topic", "credit-user-path-key",
        "PRODUCT MESSAGE");
    rabbitTemplate.destroy();
  }
}
