package com.dev.collector.controllers;

import com.dev.collector.domains.Event;
import com.dev.collector.services.EventService;
import com.fasterxml.uuid.Generators;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/event")
public class EventCollector {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity addEvent(@RequestBody Event eventRequest) {

        String transaction = Generators.timeBasedGenerator().generate().toString();
        log.info("EventCollector <addEvent>  Input Data {}", eventRequest.toString());
        try {
            eventRequest.setTransactionCode(transaction);
            eventService.addEvent(eventRequest);
        } catch (InterruptedException e) {
            log.error("EventCollector <addEvent> Transaction ID {} ERROR : {}", transaction, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }


}
