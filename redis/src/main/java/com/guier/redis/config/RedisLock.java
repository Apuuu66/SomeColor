package com.guier.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class RedisLock {
    public static void main(String[] args) {
        Config config = new Config();

        config.useSingleServer().setAddress("redis://myapp.host:6380").setPassword("fskln@#KGFghreOJ").setDatabase(0);

        RedissonClient redissonClient = Redisson.create(config);
        RLock redislock = redissonClient.getLock("REDISLOCK");
        //c6916a11-c5f1-4518-94d2-fa79f9e35953:1
        boolean isLock;
        try {
            // isLock = redislock.tryLock(500, 15000, TimeUnit.MILLISECONDS);
            // if (isLock) {
                redislock.lock();
                TimeUnit.SECONDS.sleep(17);
                System.out.println("获取锁");
            // }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // redislock.unlock();
            // redislock.unlock();
        }
    }
}
