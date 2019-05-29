package com.ley.springboot.cache.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheUtils {

    private final static LoadingCache<String, String> CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.SECONDS)
            .maximumSize(3)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return "缓存为空";
                }
            });


    public static String get(String key) throws ExecutionException {
        return CACHE.get(key);
    }


    public static void put(String key, String value) {
        CACHE.put(key, value);
    }


    public static Long size() {
        return CACHE.size();
    }


    public static LoadingCache<String, String> getCACHE() {
        return CACHE;
    }


    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder builder = new StringBuilder(256);
                builder.append(target.getClass().getName());
                builder.append(":" + method.getName());
                for (Object param : params) {
                    builder.append(":" + param.toString());
                }
                return builder.toString();
            }
        };
    }
}
