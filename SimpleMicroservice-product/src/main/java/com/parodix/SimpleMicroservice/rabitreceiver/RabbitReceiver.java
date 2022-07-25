package com.parodix.SimpleMicroservice.rabitreceiver;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {

  private final CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(final String message) {
    System.out.printf("MESSAGE RECEIVE - PRODUCT RABBIT: %s", message);
    latch.countDown();
  }
}
