package com.parodix.SimpleMicroservice.rabbitreceiver;

import org.springframework.stereotype.Component;

@Component
public final class RabbitReceiver {

  public void receiveMessage(final String message) {
    System.out.printf("MESSAGE: %s", message);
  }
}
