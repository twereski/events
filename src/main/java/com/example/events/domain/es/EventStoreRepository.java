package com.example.events.domain.es;

import com.example.events.domain.es.EventStatus;
import com.example.events.domain.es.EventStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface EventStoreRepository extends JpaRepository<EventStore, String>
{

    List<EventStore> findAllByAggregateIdOrderByCreatedAtDesc(UUID aggregateId);

    List<EventStore> findTop100ByEventStatusOrderByCreatedAt(EventStatus status);
}
