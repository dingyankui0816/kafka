package com.cn.kafka.listener;

import com.cn.kafka.constant.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @DESC: 监听 test3 topic
 * @Auther: Levi.Ding
 * @Date: 2020/12/18 11:00
 */
@Slf4j
@Component
@KafkaListener(topics = CommonConstants.TEST_3_TOPIC,groupId = CommonConstants.TEST_3_CONSUMER_GROUP)
public class Test3Listener  {

    @KafkaHandler
    public void test3 (String str, Acknowledgment acknowledgment) {
        log.info("test3, 简单消费：{}", str);
        acknowledgment.acknowledge();
    }
}
