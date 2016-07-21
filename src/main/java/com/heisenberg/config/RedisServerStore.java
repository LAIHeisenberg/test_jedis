package com.heisenberg.config;

import com.heisenberg.config.models.RedisCacheModel;
import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Heisenberg on 7/20/16.
 */
public class RedisServerStore {
    private static String SERVER_CONFIG_FILE = "redis-config.xml";
    private static String REDIS_CONFIG_ELEMENT = "servers/config";
    private static String REDIS_SERVER_ELEMENT = "servers/config/redis/server";
    private Map<String,RedisServerConfig> redisConfigMap = new HashMap<String, RedisServerConfig>();

    private String deploymentState = "development";

    public void reload(){

        Digester digester = new Digester();
        digester.setValidating(false);
        digester.push(this);

        digester.addObjectCreate(REDIS_CONFIG_ELEMENT,RedisServerConfig.class);
        digester.addSetProperties(REDIS_CONFIG_ELEMENT,"stage","stage");
        digester.addSetNext(REDIS_CONFIG_ELEMENT,"addRedisConfig");

        digester.addObjectCreate(REDIS_SERVER_ELEMENT, RedisCacheModel.class);
        digester.addSetProperties(REDIS_SERVER_ELEMENT);
        digester.addSetNext(REDIS_SERVER_ELEMENT,"addRedisServer");

        try{
            URL configUrl = ConfigurationUtils.locate(SERVER_CONFIG_FILE);
            digester.parse(configUrl.openStream());
        }catch (IOException e){
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        RedisServerConfig serverConfig = getServerConfig();
        serverConfig.init();

    }

    public void addRedisConfig(RedisServerConfig config){
        redisConfigMap.put(config.getStage(),config);
    }


    public RedisServerConfig getServerConfig(){
        System.out.println(redisConfigMap.size());
        return redisConfigMap.get(deploymentState);
    }
}
