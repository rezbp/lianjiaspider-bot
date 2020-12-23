package com.pyf.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class Runner  implements CommandLineRunner {

    @Autowired
    private RedisTemplate redisTemplate;



    @Override
    public void run(String... args) throws Exception {
        redisTemplate.opsForValue().set("gateway",66666);
    }
}
