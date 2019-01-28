package com.kafka.project.consumer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class SimpleConsumer {

	private final static String TOPIC = "SimpleTopic";
	private final static String BOOTSTRAP_SERVERS = "192.168.1.212:9092";

	private static Consumer<String, String> createConsumer() {
		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaExampleConsumer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

		// Create the consumer using props.

		final Consumer<String, String> consumer = new KafkaConsumer<>(props);
		// Subscribe to the topic.

		consumer.subscribe(Collections.singletonList(TOPIC));

		return consumer;
	}

	public static void runConsumer() throws InterruptedException {

		final Consumer<String, String> consumer = createConsumer();	
		System.out.println("create consumer done");
		final ConsumerRecords<String, String> consumerRecords = consumer.poll(10);
		
		List<String> messages = new ArrayList<>();
		System.out.println("after poll");
		consumerRecords.forEach(record -> {
			System.out.println("within for each");
			String message = record.value();
			messages.add(message);
		});

		consumer.commitAsync();

		consumer.close();
		System.out.println("Message read : ");
		System.out.println(messages);
				
	}
}
