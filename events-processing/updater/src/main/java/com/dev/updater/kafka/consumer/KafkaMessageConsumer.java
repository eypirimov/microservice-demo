package com.dev.updater.kafka.consumer;

import com.dev.updater.domains.Event;
import com.dev.updater.services.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaMessageConsumer {

    @Autowired
    private EventService eventService;

    @KafkaListener(topics = "${input.event.topic}", containerFactory = "kafkaListenerContainerFactory")
    public void getMessageFromTopic(Event message) {
        log.info("Consumed JSON Message: " + message.toString());
        eventService.updateEvent(message);
    }

}
