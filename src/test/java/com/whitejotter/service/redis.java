package com.whitejotter.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class redis {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void redisTest(){
        redisTemplate.opsForValue().set("yanzhegmaas","123456",60, TimeUnit.SECONDS);
//        redisTemplate.opsForValue().set("yanzhegma","123456");
        String name = (String) redisTemplate.opsForValue().get("yanzhegmaq");
        System.out.println(name);
    }

    @Test
    void redisTestq(){
        String name = (String) redisTemplate.opsForValue().get("yanzhegmaas");
        System.out.println(name);
    }
}
