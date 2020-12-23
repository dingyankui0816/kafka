package com.cn.kafka.config;

import com.cn.kafka.constant.CommonConstants;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.listener.ConsumerAwareErrorHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @DESC: kafka-config
 * @Auther: Levi.Ding
 * @Date: 2020/12/22 15:19
 */
@Configuration
public class KafkaConfig {


    @Bean
    public KafkaAdmin getKafkaAdmin(KafkaProperties kafkaProperties){
        Map<String,Object> props = new HashMap<>();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(props);
    }

    @Bean
    public AdminClient getAdminClient(KafkaAdmin kafkaAdmin){
        return AdminClient.create(kafkaAdmin.getConfigurationProperties());
    }

    @Bean
    public NewTopic getNewTopic(){
        return new NewTopic(CommonConstants.TEST_4_TOPIC,3,(short) 3);
    }
}
