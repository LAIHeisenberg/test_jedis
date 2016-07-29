package com.heisenberg.jedis;

import com.heisenberg.jedis.impl.RedisCallable;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;


/**
 * Created by Heisenberg on 7/22/16.
 */
public class JedisDemo {

    public static void main(String[] args){

        Set<Tuple> words = new JedisTemplate<Set<Tuple>>().execute(new RedisCallable<Set<Tuple>>() {
            public Set<Tuple> execute(Jedis jedis) {
                return jedis.zrevrangeWithScores("words", 0, -1);
            }
        });

        for (Tuple word : words){

            System.out.println(word.getElement() + " : " + word.getScore());
        }
    }
}
