package io.github.aleknik.streetcamaggregator.service;

import io.github.aleknik.streetcamaggregator.model.dto.DetectionRequest;
import io.github.aleknik.streetcamaggregator.model.dto.DetectionResponse;
import model.StreetCamInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);

    private final DetectionService detectionService;

    public MessageReceiver(DetectionService detectionService) {
        this.detectionService = detectionService;
    }

    @RabbitListener(queues = "${queue-name}")
    public void receiveMessage(final StreetCamInfo streetCamInfo) {
        log.info("Received message: {}", streetCamInfo.getImageUrl());

        final DetectionResponse detected = detectionService.detect(new DetectionRequest(streetCamInfo.getImgBase64()));

        log.info("People detected: {}", detected.getPerson());
    }

}
