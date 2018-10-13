package com.example.events.es.rabbitmq;


import com.example.events.es.EventStore;
import com.example.events.es.EventStoreException;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;

import java.util.HashMap;

public final class PublishConfig {

    private static final String KAM_NOTE_PREFIX = "customer.kam.note.";

    private static final ImmutableMap<String, String> CONF;

    static {
        HashMap<String, String> conf = new HashMap<>();
//        conf.put(ActivesInfoSaved.class.getName(), KAM_NOTE_PREFIX.concat("active.info"));
//        conf.put(BasicDataSaved.class.getName(), KAM_NOTE_PREFIX.concat("basic.data"));
//        conf.put(CreatedNoteKam.class.getName(), KAM_NOTE_PREFIX.concat("create"));
//        conf.put(CustomerContractorsSaved.class.getName(), KAM_NOTE_PREFIX.concat("contractors"));
//        conf.put(CustomerInfoSaved.class.getName(), KAM_NOTE_PREFIX.concat("customer"));
//        conf.put(FinancialSaved.class.getName(), KAM_NOTE_PREFIX.concat("financial"));
//        conf.put(NeedsSaved.class.getName(), KAM_NOTE_PREFIX.concat("need"));
//        conf.put(PassivesInfoSaved.class.getName(), KAM_NOTE_PREFIX.concat("passives"));
//        conf.put(SummarySaved.class.getName(), KAM_NOTE_PREFIX.concat("summary"));
//        conf.put(StatusChanged.class.getName(), KAM_NOTE_PREFIX.concat("status.changed"));
//        conf.put(CalendarCreated.class.getName(), KAM_NOTE_PREFIX.concat("calendar.created"));

        CONF = ImmutableMap.copyOf(conf);
    }

    public static String getRoute(@NonNull EventStore eventStore) {
        if(!CONF.containsKey(eventStore.getEventType())) {
            throw new EventStoreException("Brak konfiguracji routing dla ".concat(eventStore.getEventType()));
        }
        return CONF.get(eventStore.getEventType());
    }

    public static boolean isPublish(@NonNull EventStore eventStore) {
        return CONF.containsKey(eventStore.getEventType());
    }
}
