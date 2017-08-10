package com.aj.springbootkafkaproducer.service;

public interface KafkaProducerService {

    String sendMessageToTopic(String topicName, String message);
}
