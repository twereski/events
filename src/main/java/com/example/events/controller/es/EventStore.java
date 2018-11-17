package com.example.events.controller.es;

import com.example.events.infrastracure.rabbitmq.PublishProductConfig;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "EVENT_STORE")
public class EventStore {

    @Id
    @Type(type="uuid-char")
    @Column(columnDefinition = "VARCHAR2(36)")
    protected UUID id;

    @Column(name = "EVENT_TYPE")
    protected String eventType;

    @Column(name = "AGGREGATE_TYPE")
    protected String aggregateType;

    @Type(type="uuid-char")
    @Column(name = "AGGREGATE_ID", columnDefinition = "VARCHAR2(36)")
    protected UUID aggregateId;

    @Column(name = "VERSION")
    protected Integer version;

    @Column(name = "EMPLOYEE_ID")
    protected String employeeId;

    @Column(name = "CREATED_AT")
    protected Date createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 10)
    protected EventStatus eventStatus;

    @Lob
    @Column(name = "PAY_LOAD")
    protected String payLoad;

    public EventStore(Aggregate aggregate, Integer version, String eventSerialized, String eventType, String employeeId) {
        this.id = UUID.randomUUID();
        this.aggregateId = aggregate.getId();
        this.aggregateType = aggregate.getClass().getCanonicalName();
        this.eventType = eventType;
        this.version = version;
        this.employeeId = employeeId;
        this.createdAt = new Date();
        this.payLoad = eventSerialized;
        this.eventStatus = getInitStatus();
    }

    public void sent() {
        this.eventStatus = EventStatus.SENT;
    }

    public void sentFailed() {
        this.eventStatus = EventStatus.SENT_FAILED;
    }

    private EventStatus getInitStatus() {
        if(PublishProductConfig.isPublish(this)) {
            return EventStatus.NEW;
        }
        return EventStatus.UNSENT;
    }
}
