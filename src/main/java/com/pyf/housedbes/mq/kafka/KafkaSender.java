package com.pyf.housedbes.mq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author ADMIN
 */
@Component
public class KafkaSender {


    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public KafkaSender(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        System.out.println("kafkaTemplate.getDefaultTopic():"+kafkaTemplate.getDefaultTopic());
    }
}
