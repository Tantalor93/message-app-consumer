package com.github.tantalor93.rest;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

@Component
public class BenkyListener implements ConsumerSeekAware {

	public static List<String> LIST = new LinkedList<>();

	ThreadLocal<ConsumerSeekCallback> consumerSeekCallback;

	@KafkaListener(topics = "test")
	public void listen(String message) {
		synchronized (LIST) {
			LIST.add(message);
		}
		System.out.println("Received message: " + message);
	}

	@Override
	public void registerSeekCallback(ConsumerSeekCallback consumerSeekCallback) {
		this.consumerSeekCallback.set(consumerSeekCallback);
	}

	@Override
	public void onPartitionsAssigned(Map<TopicPartition, Long> map,
			ConsumerSeekCallback consumerSeekCallback) {

	}

	@Override
	public void onIdleContainer(Map<TopicPartition, Long> map, ConsumerSeekCallback consumerSeekCallback) {

	}
}
