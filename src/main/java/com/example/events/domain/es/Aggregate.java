package com.example.events.domain.es;


import com.google.common.collect.ImmutableMap;

import java.util.UUID;

public interface Aggregate {

    public UUID getId();

    public Integer getCurrentVersion();

    public ImmutableMap<Integer, Event> getEvents();

    public void clearEvents();
}
