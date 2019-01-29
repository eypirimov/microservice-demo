package com.dev.reporter.redis;

import com.dev.reporter.domains.Action;

import java.util.Map;

public interface RedisRepository {

    Action findAction(String postId);
}
