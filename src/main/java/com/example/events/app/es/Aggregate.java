package com.example.events.app.es;


import com.google.common.collect.ImmutableMap;

import java.util.UUID;

public interface Aggregate {

    UUID getId();

    Integer getCurrentVersion();

    ImmutableMap<Integer, Event> getEvents();

    void clearEvents();
}
