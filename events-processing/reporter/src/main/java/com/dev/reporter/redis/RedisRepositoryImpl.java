package com.dev.reporter.redis;


import com.dev.reporter.domains.Action;
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
    public Action findAction(String postId) {
        String json = (String) hashOperations.get(KEY, postId);
        return getAction(json);
    }

    private Action getAction(String json) {
        try {
            log.info("JSON {} ", json);
            if (json != null)
                return new ObjectMapper().readValue(json, Action.class);
        } catch (Exception e) {
            log.error("ERROR :", e);

        }
        return null;
    }

}
