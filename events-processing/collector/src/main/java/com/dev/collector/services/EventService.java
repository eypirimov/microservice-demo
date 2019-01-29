package com.dev.collector.services;

import com.dev.collector.domains.Event;
import com.dev.collector.kafka.producer.KafkaMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventService {

    @Autowired
    private KafkaMessageProducer messageProducer;

    @Async("asyncExecutor")
    public void addEvent(Event event) throws InterruptedException {
        messageProducer.sendMessage(event);
    }
}
