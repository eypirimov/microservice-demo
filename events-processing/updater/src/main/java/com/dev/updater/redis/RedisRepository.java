package com.dev.updater.redis;

import com.dev.updater.domains.Action;

public interface RedisRepository {

    void add(Action action);
}
