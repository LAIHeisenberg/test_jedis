package com.heisenberg.config.models;

/**
 * Created by Heisenberg on 7/20/16.
 */
public class RedisCacheModel {
    private int shard;
    private String host;
    private int port;
    private int timeout = 2500;

    public RedisCacheModel() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getShard() {
        return shard;
    }

    public void setShard(int shard) {
        this.shard = shard;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
