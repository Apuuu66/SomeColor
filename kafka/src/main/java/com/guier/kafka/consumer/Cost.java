package com.guier.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Cost {
    private static String topic = "test-topic";
    private static KafkaConsumer<String, String> consumer;
    public static final AtomicBoolean isRunning = new AtomicBoolean(true);

    @Test
    public void t1() {
        consumer = new KafkaConsumer<String, String>(ConsumerInitConfig.initConfig());
        consumer.subscribe(Collections.singleton(topic));

        while (isRunning.get()) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(String.format(
                        "topic = %s, partition = %s, key = %s, value = %s",
                        record.topic(), record.partition(),
                        record.key(), record.value()
                ));
                if (record.value().equals("done")) {
                    isRunning.set(false);
                }
            }
        }
    }

    @Test
    public void t2() {
        consumer = new KafkaConsumer<String, String>(ConsumerInitConfig.initConfig());
        consumer.subscribe(Collections.singleton(topic));

        while (isRunning.get()) {
            ConsumerRecords<String, String> records = consumer.poll(100);
//            获取指定分区的record
            for (TopicPartition topicPartition : records.partitions()) {
                for (ConsumerRecord<String, String> record : records.records(topicPartition)) {//records(String topic),按主题列表消费
                    System.out.println(record.partition() + "-" + record.key() + ":" + record.value());
                }
            }
        }
    }
    @Test
    public void t3() {
        consumer = new KafkaConsumer<String, String>(ConsumerInitConfig.initConfig());
        TopicPartition topicPartition = new TopicPartition(topic, 0);
        consumer.assign(Collections.singleton(topicPartition));
        long lastConsumedOffset = -1;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            if (records.isEmpty()) {
                break;
            }
            List<ConsumerRecord<String, String>> partitionRecords = records.records(topicPartition);
            lastConsumedOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
//            consumer.commitSync();
        }
        System.out.println("consumed offset is " + lastConsumedOffset);
        OffsetAndMetadata offsetAndMetadata = consumer.committed(topicPartition);
        System.out.println("commited offset is "+offsetAndMetadata.offset());
        long position = consumer.position(topicPartition);
        System.out.println("the offset of the next record is " + position);
    }
}
