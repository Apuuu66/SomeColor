package com.guier.redis.config;

import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class DistRedLock {
    public static void main(String[] args) {
        Config config1 = new Config();
        config1.useSingleServer().setAddress("redis://myapp.host:6380")
                .setPassword("fskln@#KGFghreOJ").setDatabase(0);
        RedissonClient redissonClient1 = Redisson.create(config1);

        Config config2 = new Config();
        config2.useSingleServer().setAddress("redis://myapp.host:6381")
                .setPassword("fskln@#KGFghreOJ").setDatabase(0);
        RedissonClient redissonClient2 = Redisson.create(config2);

        Config config3 = new Config();
        config3.useSingleServer().setAddress("redis://myapp.host:6382")
                .setPassword("fskln@#KGFghreOJ").setDatabase(0);
        RedissonClient redissonClient3 = Redisson.create(config3);

        String resourceName = "REDLOCK_KEY";

        RLock lock1 = redissonClient1.getLock(resourceName);
        RLock lock2 = redissonClient2.getLock(resourceName);
        RLock lock3 = redissonClient3.getLock(resourceName);
// 向3个redis实例尝试加锁
        RedissonRedLock redLock = new RedissonRedLock(lock1, lock2, lock3);
        boolean isLock;
        try {
            // isLock = redLock.tryLock();
            // 500ms拿不到锁, 就认为获取锁失败。10000ms即10s是锁失效时间。
            isLock = redLock.tryLock(500, 15000, TimeUnit.MILLISECONDS);
            System.out.println("isLock : " + isLock + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
            if (isLock) {
                TimeUnit.SECONDS.sleep(30);
            }
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redLock.unlock();
        }
    }
}
