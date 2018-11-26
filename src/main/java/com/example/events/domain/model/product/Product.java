package com.example.events.domain.model.product;


import com.example.events.controller.es.Aggregate;
import com.example.events.controller.es.Event;
import com.example.events.domain.model.Money;
import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Product implements Aggregate {

    UUID id;

    Integer currentVersion;

    String name;

    Money basicPrice;


    public Product(UUID id, String name, Money basicPrice) {
        this.id = id;
        this.name = name;
        this.basicPrice = basicPrice;
    }

    @Override
    public ImmutableMap<Integer, Event> getEvents() {
        return ImmutableMap.of();
    }

    @Override
    public void clearEvents() {

    }
}
