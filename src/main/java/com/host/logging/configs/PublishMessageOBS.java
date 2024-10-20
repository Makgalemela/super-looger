package com.host.logging.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PublishMessageOBS {
//    private static final Logger logger = LoggerFactory.getLogger(PublishMessageOBS.class);
//
//
//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    public void MessagePublisher(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    public PublishMessageOBS(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//
//    @Bean
////    @HostEventLogger("Logged this event")
//    public void publishMessage2() {
//
//       Map<String, Object> message = new HashMap<>();
//       message.put("data", "STAGE_1");
//       String exchange = "host.2.host.test.config";
//       String routingKey = "routing.key.host.2.host.test.config";
//       rabbitTemplate.convertAndSend(exchange, routingKey, message);
//       logger.info("Message published: " + message);
//    }
}
