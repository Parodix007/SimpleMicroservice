package com.parodix.SimpleMicroservice.rabitreceiver;

import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {
  public void receiveMessage(final String message) {
    System.out.printf("MESSAGE: %s", message);
  }
}
