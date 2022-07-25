package com.parodix.SimpleMicroservice.rabbitconfig;

import com.parodix.SimpleMicroservice.rabitreceiver.RabbitReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitConfig {
  private static final String EXCHANGE_TOPIC = "credit-product-topic";
  private static final String QUEUE_NAME = "credit-product-queue";
  private static final String PATH_KEY = "credit-product-path-key";

  @Bean
  Queue getQueue() {
    return new Queue(QUEUE_NAME, false);
  }

  @Bean
  TopicExchange getExchange() {
    return new TopicExchange(EXCHANGE_TOPIC);
  }

  @Bean
  Binding binding(final Queue queue, final TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(PATH_KEY);
  }

  @Bean
  MessageListenerAdapter getMessageListenerAdapter(RabbitReceiver rabbitReceiver) {
    return new MessageListenerAdapter(rabbitReceiver, "receiveMessage");
  }

  @Bean
  SimpleMessageListenerContainer getContainer(final ConnectionFactory connectionFactory, final
  MessageListenerAdapter messageListenerAdapter) {
    final SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

    container.setConnectionFactory(connectionFactory);
    container.setMessageListener(messageListenerAdapter);
    container.setQueueNames(QUEUE_NAME);

    return container;
  }
}
