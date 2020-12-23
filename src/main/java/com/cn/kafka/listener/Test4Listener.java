package com.cn.kafka.listener;

import com.alibaba.fastjson.JSON;
import com.cn.kafka.constant.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @DESC: test4 listener
 * @Auther: Levi.Ding
 * @Date: 2020/12/22 15:34
 */
@Slf4j
@Component
@KafkaListener(topics = CommonConstants.TEST_4_TOPIC,groupId = CommonConstants.TEST_4_CONSUMER_GROUP,errorHandler = "customConsumerAwareErrorHandler")
public class Test4Listener {

    @KafkaHandler
    public void onMessage(List<String> strs, Acknowledgment acknowledgment){

        log.info("test4, 简单消费：{}", JSON.toJSONString(strs));
        if (1==1){
            throw new RuntimeException("报错");
        }
        acknowledgment.acknowledge();

    }
}
