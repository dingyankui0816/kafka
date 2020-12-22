package com.cn.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @DESC: Kafka Controller
 * @Auther: Levi.Ding
 * @Date: 2020/12/18 11:00
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @RequestMapping()
    public void sendKafka(){
        kafkaTemplate.send("test3","Hello World ! 丁");
    }
}
