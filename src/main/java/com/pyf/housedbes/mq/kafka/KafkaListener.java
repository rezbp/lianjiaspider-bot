package com.pyf.housedbes.mq.kafka;

import org.springframework.stereotype.Component;

/**
 * @author ADMIN
 */
@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "pyfes")
    public void processMsg(String msg) {
        System.out.println("pyfes:processMsg" + msg);
    }
}
