package com.example.events.controller.es;


public class EventStoreException extends RuntimeException  {

    public EventStoreException(String message) {
        super(message);
    }

    public EventStoreException(String message, Throwable throwable) {
        super(message, throwable);
    }
}