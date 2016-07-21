package com.heisenberg.config;

import com.heisenberg.config.models.RedisCacheModel;
import org.apache.commons.configuration.Configuration;
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
public class TestDigester {


    public static void main(String[] args){

        RedisServerStore redisServerStore = new RedisServerStore();
        redisServerStore.reload();
    }

}
