package com.example.events.domain.es;

import lombok.NonNull;

public interface PublishConfig {
    boolean isPublish(@NonNull EventStore eventStore);
}
