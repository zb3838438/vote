package com.zb.vote.util;

import com.zb.vote.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

@Component
public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;
    private Jedis jedis = null;


    public Map<String, String> hgetAll(String key) {
        jedis = jedisPool.getResource();
        return jedis.hgetAll(key);
    }

    public String hmset(String key, Map<String, String> map) {
        jedis = jedisPool.getResource();
        return jedis.hmset(key, map);
    }
}
