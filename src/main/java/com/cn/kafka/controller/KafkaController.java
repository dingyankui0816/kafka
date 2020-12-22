package com.cn.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @DESC: Kafka Controller
 * @Auther: Levi.Ding
 * @Date: 2020/12/18 11:00
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @RequestMapping(value = "/send-msg/{msg}/{key}/{id}",method = RequestMethod.GET)
    public void sendKafka(@PathVariable String msg,@PathVariable String key,@PathVariable Integer id){
         kafkaTemplate.send("test3",id,key,msg);
    }
}
