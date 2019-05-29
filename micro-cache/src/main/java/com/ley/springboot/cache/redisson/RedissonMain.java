package com.ley.springboot.cache.redisson;

import org.redisson.Redisson;
import org.redisson.RedissonLock;
import org.redisson.api.RLock;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class RedissonMain {

    public static void main(String[] args) throws InterruptedException {
        RLock rLock = Redisson.create().getLock("anyLock");

        //支持过期解锁功能
        rLock.lock(10, TimeUnit.SECONDS);
        boolean res = rLock.tryLock(100, 10, TimeUnit.SECONDS);
        System.out.println("res: " + res);
    }
}
