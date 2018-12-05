package com.example.events.infrastracure.rabbitmq;


import com.example.events.app.es.EventStore;
import com.example.events.app.es.EventStoreException;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;

import java.util.HashMap;

public final class PublishProductConfig {

    private static final String PRODUCT_PREFIX = "example.product.";

    private static final ImmutableMap<String, String> CONF;

    static {
        HashMap<String, String> conf = new HashMap<>();
//        conf.put(ProductActivated.class.getName(), PRODUCT_PREFIX.concat("activated"));

        CONF = ImmutableMap.copyOf(conf);
    }

    public static String getRoute(@NonNull EventStore eventStore) {
        if(!CONF.containsKey(eventStore.getEventType())) {
            throw new EventStoreException("Brak konfiguracji routing dla ".concat(eventStore.getEventType()));
        }
        return CONF.get(eventStore.getEventType());
    }

    public static boolean isPublish(@NonNull EventStore eventStore) {
        return CONF.containsKey(eventStore.getEventType());
    }
}
