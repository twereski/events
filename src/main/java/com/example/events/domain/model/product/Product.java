package com.example.events.domain.model.product;


import com.example.events.domain.es.Aggregate;
import com.example.events.domain.es.Event;
import com.example.events.domain.model.Money;
import com.google.common.collect.ImmutableMap;
import lombok.Getter;

import java.util.UUID;

@Getter
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
        return null;
    }

    @Override
    public void clearEvents() {

    }
}
