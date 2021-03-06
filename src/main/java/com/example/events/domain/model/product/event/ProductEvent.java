package com.example.events.domain.model.product.event;

import com.example.events.app.es.Event;

public abstract class ProductEvent implements Event {

    private final String aggregateName = "product";

    @Override
    public String getAggregateName() {
        return aggregateName;
    }
}
