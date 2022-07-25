package com.parodix.SimpleMicroservice.rabbitreceiver;

import com.parodix.SimpleMicroservice.services.CustomerService;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public final class RabbitReceiver {

  private final CustomerService customerService;

  public RabbitReceiver(final CustomerService customerService) {
    this.customerService = customerService;
  }

  private final CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(final String message) {
    System.out.printf("MESSAGE RECEIVE - USER RABBIT: %s", message);
    switch (message.toLowerCase(Locale.ROOT)) {
      case "getcustomer" -> customerService.getCustomers();
      default -> System.out.println("NO CASE FOR THIS KEY: " + message);
    }
//    latch.countDown();
  }
}
