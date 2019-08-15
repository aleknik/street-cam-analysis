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
    private final CameraIndexerService cameraIndexerService;

    public MessageReceiver(DetectionService detectionService, CameraIndexerService cameraIndexerService) {
        this.detectionService = detectionService;
        this.cameraIndexerService = cameraIndexerService;
    }

    @RabbitListener(queues = "${queue-name}")
    public void receiveMessage(final StreetCamInfo streetCamInfo) {
        log.info("Received message: {}", streetCamInfo.getImageUrl());

        final DetectionResponse detected = detectionService.detect(new DetectionRequest(streetCamInfo.getImgBase64()));

        cameraIndexerService.index(detected, streetCamInfo.getDate(), streetCamInfo.getLatitude(),
                streetCamInfo.getLongitude(), streetCamInfo.getName(), streetCamInfo.getId());

        log.info("People detected: {}", detected.getPerson());
    }

}
