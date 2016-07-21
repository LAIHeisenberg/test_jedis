package com.heisenberg.config;

import com.heisenberg.config.models.RedisCacheModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Heisenberg on 7/20/16.
 */
public class RedisServerConfig {

    private String stage;
    private Map<Integer,RedisCacheModel> redisServers = new HashMap<Integer, RedisCacheModel>();

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public void addRedisServer(RedisCacheModel redisCacheModel){
        redisServers.put(redisCacheModel.getShard(),redisCacheModel);
    }

    public void init(){

        Set<Map.Entry<Integer, RedisCacheModel>> entries = redisServers.entrySet();
        for (Map.Entry<Integer,RedisCacheModel> entry : entries){
            System.out.println(entry.getKey()+" : "+entry.getValue().getHost());
        }
    }

}
