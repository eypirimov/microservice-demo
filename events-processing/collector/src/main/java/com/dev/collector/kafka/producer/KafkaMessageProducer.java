package com.dev.collector.kafka.producer;

import com.dev.collector.domains.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaMessageProducer {

    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    @Value("${input.event.topic}")
    private String inputEventTopic;

    public void sendMessage(Event message) {
        log.info("<sendMessage> --> Sending Data  ( {} ) to partition  ", message.toString());
        kafkaTemplate.send(inputEventTopic,message);
    }

}
