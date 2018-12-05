package com.example.events.app.es;

import lombok.NonNull;

public interface PublishConfig {
    boolean isPublish(@NonNull EventStore eventStore);
}
