package com.heisenberg;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JedisPool jedisPool = new JedisPool("localhost",6379);
        Jedis client = jedisPool.getResource();
        client.zadd("words",26,"Z");
        Set<String> words = client.zrange("words", 0, -1);
        for (String word : words){
            System.out.println(word);
        }

        Map<String, String> env = System.getenv();

        Set<Map.Entry<String, String>> entries = env.entrySet();

        /*for (Map.Entry<String,String> entry : entries){
            System.out.println("key: "+entry.getKey()+"     values: "+entry.getValue());
        }

        String deployment_stage = System.getenv("DEPLOYMENT_STAGE");
        System.out.println(deployment_stage);*/
        Properties properties = System.getProperties();
        System.out.println(properties);




//        new Jedis()

    }
}
