package com.kafka.project.producer;

import java.util.*;
import org.apache.kafka.clients.producer.*;
public class SimpleProducer {
                                                    
    public static void startProducer() {
                                                    
        String topicName = "SimpleTopic";
        String key = "Key1";
        String value = "Value-1";
                                                    
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.212:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");         
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
                                                    
        Producer<String, String> producer = new KafkaProducer<>(props);
                                                    
        ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key,value);
        producer.send(record);
        producer.close();
                                                    
        System.out.println("SimpleProducer Completed.");
    }
}