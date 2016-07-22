package com.heisenberg.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Heisenberg on 7/22/16.
 */
public class JedisPoolStore {

    static class JedisPoolHolder{

        public static JedisPool instance = new JedisPool("localhost",6379);
    }

    public Jedis getJedis(){
        return JedisPoolHolder.instance.getResource();
    }



}
