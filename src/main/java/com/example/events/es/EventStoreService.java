package com.example.events.es;


import com.example.events.es.rabbitmq.EventPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EventStoreService {

    private ObjectMapper objectMapper;

    private EventStoreRepository eventStoreRepository;

    private EventPublisher eventPublisher;

    @Transactional
    public void saveEvents(Aggregate aggregate) {

        List<EventStore> eventStoreList = new ArrayList<>();

        aggregate.getEvents().forEach((version, event) -> {
            String eventSerialized;
            try {
                eventSerialized = objectMapper.writeValueAsString(event);
            } catch (IOException e) {
                log.error(e.getMessage());
                throw new EventStoreException("Bład podczas zapisu zdarzenia", e);
            }
            EventStore eventStore = new EventStore(aggregate, version, eventSerialized, event.getClass().getCanonicalName(), event.getEmployeeId());
            eventStoreList.add(eventStore);

        });

        eventStoreRepository.saveAll(eventStoreList);
        aggregate.clearEvents();
    }

    public void publishEvents() {
        List<EventStore> events =  eventStoreRepository.findTop100ByEventStatusOrderByCreatedAt(EventStatus.NEW);

        events.forEach(e -> {
            try {
                eventPublisher.publish(e);
                e.sent();
            } catch (Exception ex) {
                log.error(ex.getMessage());
                e.sentFailed();
            }
        });

        eventStoreRepository.saveAll(events);
    }

}
