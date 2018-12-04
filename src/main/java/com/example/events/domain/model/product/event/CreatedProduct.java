package com.example.events.domain.model.product.event;
import com.example.events.domain.model.Money;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@EqualsAndHashCode(callSuper = true)
public class CreatedProduct extends ProductEvent {

    public static final String TYPE = "product.created";

    private final UUID aggregateId;
    private final String eventType;
    private final LocalDateTime createdAt;
    private final String name;
    private final Money basicPrice;

    public CreatedProduct(UUID aggregateId, String name, Money basicPrice) {
        this.aggregateId = aggregateId;
        this.eventType = TYPE;
        this.createdAt = LocalDateTime.now();
        this.name = name;
        this.basicPrice = basicPrice;
    }
}
