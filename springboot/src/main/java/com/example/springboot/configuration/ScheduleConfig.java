package com.example.springboot.configuration;

import com.example.springboot.task.Task1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@EnableScheduling
// @Configuration
public class ScheduleConfig {
    private AtomicInteger count = new AtomicInteger(1);
    @Autowired
    Task1 task1;

    @Scheduled(cron = "0/2 * * * * ?")
    private void configureTask2() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        int i = count.get();
        int j = count.getAndAdd(1);

        System.out.println(i + "--定时执行：" + ",time: " + date);
        System.out.println(task1.exec(j));
    }
}
