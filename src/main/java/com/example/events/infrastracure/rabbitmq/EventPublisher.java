package com.example.events.infrastracure.rabbitmq;


import com.example.events.controller.es.EventStore;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    private final RabbitTemplate rabbitTemplate;

    private final Exchange exchange;

    public EventPublisher(RabbitTemplate rabbitTemplate, Exchange exchange
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void publish(EventStore eventStore) {
        rabbitTemplate.convertAndSend(exchange.getName(), PublishProductConfig.getRoute(eventStore), eventStore.getPayLoad());
    }

}
