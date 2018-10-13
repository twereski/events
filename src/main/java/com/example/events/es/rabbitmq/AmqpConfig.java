package com.example.events.es.rabbitmq;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class AmqpConfig {

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("events.event.store");
    }
}
