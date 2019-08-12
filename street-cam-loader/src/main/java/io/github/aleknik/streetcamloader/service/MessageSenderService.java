package io.github.aleknik.streetcamloader.service;

import model.StreetCamInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {

    @Value("${topic-exchange-name}")
    private String topicExchangeName;

    @Value("${routing-key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;


    public MessageSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(StreetCamInfo streetCamInfo) {

        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, streetCamInfo);

    }
}
