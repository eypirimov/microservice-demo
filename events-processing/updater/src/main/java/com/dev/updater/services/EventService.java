package com.dev.updater.services;

import com.dev.updater.redis.RedisRepository;
import com.dev.updater.domains.Action;
import com.dev.updater.domains.Event;
import com.dev.updater.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventService {

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private EventRepository eventRepository;


    public void updateEvent(Event event) {
        try {
            eventRepository.insertEvent(event);
            eventRepository.updateActionReport(event.getPostId(), event.getActionType());
            updateCache(event.getPostId());
        } catch (Exception e) {
            log.error("<updateEvent> ERROR : {}", e.getMessage());
        }
    }

    private void updateCache(String postId) {
        Action action = eventRepository.getActionByPostId(postId);
        action.setPostId(postId);
        redisRepository.add(action);
    }

}
