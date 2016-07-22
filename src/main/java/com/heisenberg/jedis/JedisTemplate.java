package com.heisenberg.jedis;

import com.heisenberg.jedis.impl.RedisCallable;
import redis.clients.jedis.Jedis;

/**
 * Created by Heisenberg on 7/22/16.
 */
public class JedisTemplate<T> {

    private static Jedis jedis = new JedisPoolStore().getJedis();

    public JedisTemplate(){};

    public T execute(RedisCallable<T> redisCallable){

        try {
            return redisCallable.execute(jedis);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            jedis.close();
        }


    }
}
