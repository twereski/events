package com.example.events.domain.model.product.event;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@EqualsAndHashCode(callSuper = true)
public class Bought extends ProductEvent {

    public static final String TYPE = "product.bought";

    private final UUID aggregateId;
    private final String eventType;
    private final LocalDateTime createdAt;

    public Bought(UUID aggregateId) {
        this.aggregateId = aggregateId;
        this.eventType = TYPE;
        this.createdAt = LocalDateTime.now();
    }
}
