package com.example.events.controller.es;


import java.time.LocalDateTime;
import java.util.UUID;

public interface Event {

    UUID getAggregateId();
    String getAggregateName();
    String getEventType();
    LocalDateTime getCreatedAt();
}
