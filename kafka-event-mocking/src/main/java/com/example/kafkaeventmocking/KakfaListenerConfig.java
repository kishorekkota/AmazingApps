package com.example.kafkaeventmocking;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KakfaListenerConfig {


    @Value(value="${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;


    @Bean
    public ConsumerFactory<String, String> consumerFactory() {

        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                "groupId");
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String>
//    kafkaListenerContainerFactory() {
//
//        ConcurrentKafkaListenerContainerFactory<String, String> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//
//    @Bean("adminClient")
//    public AdminClient kafkaAdmin() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//
//        config.put(AdminClientConfig.CLIENT_ID_CONFIG, "consumer-group-id");
//        config.put("security.protocol", "PLAINTEXT");
//        config.put("security.mechanism", "PLAINTEXT");
//        //config.put(AdminClientConfig.RETRIES_CONFIG, "3");
//        return AdminClient.create(config);
//        //return new KafkaAdmin(config);
//    }

    @Bean
    public NewTopic topicWeatherLog() {
        return new NewTopic("weather-log2", 2, (short) 1);
    }




}
