package com.cn.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @DESC: 监听 test3 topic
 * @Auther: Levi.Ding
 * @Date: 2020/12/18 11:00
 */
@Slf4j
@Component
@KafkaListener(topics = "test3")
public class Test3Listener  {

    @KafkaHandler
    public void test3 (String str, Acknowledgment acknowledgment) {
        log.info("简单消费：{}", str);
        acknowledgment.acknowledge();
    }
}
