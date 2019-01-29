package com.dev.reporter.services;

import com.dev.reporter.domains.Action;
import com.dev.reporter.redis.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private RedisRepository redisRepository;

    public Action getActionCountByPostId(String postId) {
        return redisRepository.findAction(postId);
    }
}
