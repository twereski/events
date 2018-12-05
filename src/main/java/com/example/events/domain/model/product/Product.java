package com.example.events.domain.model.product;


import com.example.events.app.es.Aggregate;
import com.example.events.app.es.Event;
import com.example.events.domain.ExceptionMessage;
import com.example.events.domain.ProductException;
import com.example.events.domain.model.Money;
import com.example.events.domain.model.product.event.Bought;
import com.example.events.domain.model.product.event.CreatedProduct;
import com.example.events.domain.model.product.event.Paid;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Product implements Aggregate {

    private UUID id;

    private Map<Integer, Event> events;

    private Integer currentVersion;

    private String name;

    private Money basicPrice;

    private ProductState state;


    public Product(UUID id, String name, Money basicPrice) {
        this.id = id;
        this.name = name;
        this.basicPrice = basicPrice;
        this.state = ProductState.NEW;
        this.events = Maps.newHashMap();
        this.currentVersion = 0;
        addEvent(new CreatedProduct(id, name, basicPrice));
    }

    public void buy() {
        if(!this.state.equals(ProductState.NEW)) {
            throw new ProductException(ExceptionMessage.WRONG_PRODUCT_STATE);
        }
        this.state = ProductState.BOUGHT;
        addEvent(new Bought(id));
    }

    public void pay() {
        if(!this.state.equals(ProductState.BOUGHT)) {
            throw new ProductException(ExceptionMessage.WRONG_PRODUCT_STATE);
        }
        this.state = ProductState.PAID;
        addEvent(new Paid(id));
    }

    @Override
    public ImmutableMap<Integer, Event> getEvents() {
        return ImmutableMap.copyOf(events);
    }

    @Override
    public void clearEvents() {
        this.events.clear();
    }

    private void addEvent(Event event) {
        currentVersion++;
        events.put(currentVersion, event);
    }
}
