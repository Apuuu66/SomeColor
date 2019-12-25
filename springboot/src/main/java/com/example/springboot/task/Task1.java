package com.example.springboot.task;

import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class Task1 {
    public static final ReentrantLock lock = new ReentrantLock();
    public static final ThreadPoolExecutor exec = new ThreadPoolExecutor(2, 3, 0L,
            TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(3), (r, executor) -> System.out.println(Thread.currentThread().getName() + "我被拒绝了"));

    public int exec(int c) {
        exec.submit(() -> runTask(c));
        /*
         * 设置核心线程是否存活，默认没有任务时，核心线程处于阻塞状态
         * 同时keepAliveTime必须大于0L
         */
        // exec.allowCoreThreadTimeOut(true);
        return 1;
    }

    public void runTask(int i) {

        if (lock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + "正在执行啊");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "抢不到锁哟");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
