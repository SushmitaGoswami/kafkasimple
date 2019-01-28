package com.kafka.project.Main;

import com.kafka.project.consumer.SimpleConsumer;
import com.kafka.project.producer.SimpleProducer;

public class Main {
	
	public static void main(String [] args) {
		SimpleProducer.startProducer();
//		try {
//			SimpleConsumer.runConsumer();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
