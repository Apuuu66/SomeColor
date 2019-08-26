package com.guier.kafka.consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class ConsumerInitConfig {
    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //多个server需要用","隔开，例如"ip1:port,ip2:port"
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.44.138:9092");
        //默认为空，设置成具有一定业务意义的名称
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "kafkaStudy");
        //默认为空，kafka自动生成非空字符串如consumer-1，consumer-2
//        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "client.id.demo");
        return properties;
    }
}
