package com.example.events.controller.es;

import lombok.NonNull;

public interface PublishConfig {
    boolean isPublish(@NonNull EventStore eventStore);
}
