package com.guier.kafka.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Subscribe {
    private static String topic="test-topic";
    private static KafkaConsumer<String, String> consumer;

    public static void main(String[] args) {
        consumer = new KafkaConsumer<String, String>(ConsumerInitConfig.initConfig());
        consumer.subscribe(Collections.singleton(topic));

    }

    public void subscribe() {
        consumer = new KafkaConsumer<String, String>(ConsumerInitConfig.initConfig());

        //订阅一个
        consumer.subscribe(Collections.singleton("topic1"));
        //订阅两个
        consumer.subscribe(Arrays.asList("topic2","topic3"));
        //正则订阅
        consumer.subscribe(Pattern.compile("topic-.*"));
        //注意最终订阅是以左后一个调用subscribe方法的主题为准。

        //订阅某些主题的特定分区
        //订阅某主题的1分区。
        consumer.assign(Arrays.asList(new TopicPartition(topic, 1)));
    }

        //获取分区信息，事先不知道主题有多少个分区。
    public void getPartitionInfo() {
        consumer = new KafkaConsumer<String, String>(ConsumerInitConfig.initConfig());
        ArrayList<TopicPartition> topicPartitions = new ArrayList<>();
        List<PartitionInfo> partitionInfos = consumer.partitionsFor(topic);
        if (partitionInfos != null) {
            for (PartitionInfo partitionInfo : partitionInfos) {
                topicPartitions.add(new TopicPartition(partitionInfo.topic(), partitionInfo.partition()));
            }
        }
        //订阅全部分区，可过滤掉部分分区
        consumer.assign(topicPartitions);
    }
}
