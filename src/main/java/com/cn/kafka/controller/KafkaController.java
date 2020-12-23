package com.cn.kafka.controller;

import com.cn.kafka.constant.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
         kafkaTemplate.send(CommonConstants.TEST_3_TOPIC,id,key,msg);
    }

    @RequestMapping(value = "/send-msg-list/{msg}/{count}",method = RequestMethod.GET)
    public void sendKafkaList(@PathVariable String msg,@PathVariable int count) throws InterruptedException {
        for (int i = 0;i<count;i++){
            kafkaTemplate.send(CommonConstants.TEST_4_TOPIC,msg+"-"+i);
            TimeUnit.MILLISECONDS.sleep(50);
        }
    }
}
