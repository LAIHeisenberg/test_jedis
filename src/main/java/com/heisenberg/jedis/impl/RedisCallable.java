package com.heisenberg.jedis.impl;

import redis.clients.jedis.Jedis;

/**
 * Created by Heisenberg on 7/22/16.
 */
public interface RedisCallable<T> {
    public T execute(Jedis jedis);
}
