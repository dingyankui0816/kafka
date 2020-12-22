package com.cn.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class KafkaApplicationTests {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Test
    void contextLoads() throws InterruptedException {
//        kafkaTemplate.send("test3","Hello World ! 丁");

        TimeUnit.MINUTES.sleep(2);

    }

}
