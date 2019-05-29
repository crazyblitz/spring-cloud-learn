package com.ley.springboot.cache.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisOperations;

import java.util.List;

/**
 * 支持每个缓存的时间配置
 * **/
public class CustomizedRedisCacheManager extends RedisCacheManager {

    public CustomizedRedisCacheManager(RedisOperations redisOperations) {
        super(redisOperations);
    }

    @Override
    public Cache getCache(String name) {
        String[] cacheParams = name.split("##");
        String cacheName = cacheParams[0];
        Long expireTime = this.computeExpiration(cacheName);
        if (cacheParams.length > 1) {
            expireTime = Long.parseLong(cacheParams[1]);
            this.setDefaultExpiration(expireTime);
        }
        Cache cache = super.getCache(cacheName);
        return cache;
    }


    /**
     * 示例
     **/
    @Cacheable(value = "CustomizedRedisCacheManager##80", keyGenerator = "keyGenerator")
    public List<String> findAll() {
        return null;
    }
}
