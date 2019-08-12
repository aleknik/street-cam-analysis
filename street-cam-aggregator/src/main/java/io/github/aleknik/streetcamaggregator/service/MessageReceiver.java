package io.github.aleknik.streetcamaggregator.service;

import model.StreetCamInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);

    @RabbitListener(queues = "${queue-name}")
    public void receiveMessage(final StreetCamInfo streetCamInfo) {
        log.info("Received message: {}", streetCamInfo.getImageUrl());
        log.info("Done");
    }

}
