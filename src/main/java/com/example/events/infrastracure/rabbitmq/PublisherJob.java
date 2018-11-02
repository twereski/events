package com.example.events.infrastracure.rabbitmq;


import com.example.events.domain.es.EventStoreService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

//@QuartzJob(name="ContactEventStore", cronExp="0 * * * * ?" )
public class PublisherJob extends QuartzJobBean {

    @Autowired
    private EventStoreService eventStoreService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        eventStoreService.publishEvents();
    }
}
