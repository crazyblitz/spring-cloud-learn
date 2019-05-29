package com.ley.springboot.cache;


import com.ley.springboot.cache.cache.CacheUtils;

import java.util.concurrent.ExecutionException;

public class CacheApplication {

    public static void main(String[] args) throws ExecutionException {
        System.out.println(CacheUtils.get("1"));
        CacheUtils.put("1", "admin1");
        CacheUtils.put("2", "admin2");
        CacheUtils.put("3", "admin3");
        CacheUtils.put("4", "admin4");
        System.out.println(CacheUtils.get("1"));
        System.out.println(CacheUtils.size());
    }
}
