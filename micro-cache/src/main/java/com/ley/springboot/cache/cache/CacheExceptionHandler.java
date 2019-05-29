package com.ley.springboot.cache.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheExceptionHandler extends CachingConfigurerSupport {


    @Bean
    public CacheErrorHandler errorHandler() {
        CacheErrorHandler handler = new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {

            }

            @Override
            public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {

            }

            @Override
            public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {

            }

            @Override
            public void handleCacheClearError(RuntimeException exception, Cache cache) {

            }
        };
        return handler;
    }
}
