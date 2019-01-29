package com.dev.updater.redis;


import com.dev.updater.domains.Action;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Slf4j
@Repository
public class RedisRepositoryImpl implements RedisRepository {

    private static final String KEY = "action";

    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> template;

    // inject the template as HashOperations
    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOperations;

    @Override
    public void add(Action action) {
        String json = getJsonString(action);
        hashOperations.put(KEY, action.getPostId(), json);
    }

    private String getJsonString(Action action) {
        try {
            return new ObjectMapper().writeValueAsString(action);
        } catch (Exception e) {
            log.error("ERROR : ", e.getMessage());
        }
        return null;
    }

}
