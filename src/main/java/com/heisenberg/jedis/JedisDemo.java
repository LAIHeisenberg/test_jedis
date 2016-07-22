package com.heisenberg.jedis;

import com.heisenberg.jedis.impl.RedisCallable;
import redis.clients.jedis.Jedis;


/**
 * Created by Heisenberg on 7/22/16.
 */
public class JedisDemo {

    public static void main(String[] args){

        Long count = new JedisTemplate<Long>(new RedisCallable<Long>(){
            public Long execute(Jedis jedis) {
                jedis.zadd("jedis",1,"test1");
                Long count = jedis.zcard("jedis");
                return count;
            }
        });
    }
}
