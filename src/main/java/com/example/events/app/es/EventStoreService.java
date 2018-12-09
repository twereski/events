package com.example.events.app.es;


import com.example.events.infrastracure.rabbitmq.EventPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@AllArgsConstructor
public class EventStoreService {

    private ObjectMapper objectMapper;

    private EventStoreRepository eventStoreRepository;

    private EventPublisher eventPublisher;

    @Transactional
    public void saveEvents(Aggregate aggregate) {
        List<EventStore> eventStoreList = publishEvents(
                aggregate.getEvents().entrySet().stream().map(
                        entry -> {
                            String eventSerialized;
                            try {
                                eventSerialized = objectMapper.writeValueAsString(entry.getValue());
                            } catch (IOException e) {
                                log.error(e.getMessage());
                                throw new EventStoreException("Bład podczas zapisu zdarzenia", e);
                            }
                            return new EventStore(entry.getValue(), entry.getKey(), eventSerialized);
                        })
        ).collect(Collectors.toList());
        eventStoreRepository.saveAll(eventStoreList);
        aggregate.clearEvents();
    }

    private Stream<EventStore> publishEvents(Stream<EventStore> events) {

        return events.peek(e -> {
            try {
                eventPublisher.publish(e);
                e.sent();
            } catch (Exception ex) {
                log.error(ex.getMessage());
                e.sentFailed();
            }
        });
    }

}
