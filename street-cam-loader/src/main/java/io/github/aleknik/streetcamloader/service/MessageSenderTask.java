package io.github.aleknik.streetcamloader.service;

import model.StreetCamInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageSenderTask {

    private static final Logger log = LoggerFactory.getLogger(MessageSenderTask.class);

    final private StreetCamService streetCamService;
    final private MessageSenderService messageSenderService;


    public MessageSenderTask(StreetCamService streetCamService, MessageSenderService messageSenderService) {
        this.streetCamService = streetCamService;
        this.messageSenderService = messageSenderService;
    }

    @Scheduled(fixedDelay = 300000)
    public void task() {

        int limit = 50;
        int offset = 0;
        int responseCount = limit;
        int total = 1000;

        while (responseCount >= limit && offset < total) {
            final List<StreetCamInfo> cameras = streetCamService.getCameras(limit, offset);
            responseCount = cameras.size();
            offset += responseCount;

            log.info("Response {}", responseCount);

            for (StreetCamInfo camera : cameras) {
                messageSenderService.send(camera);
            }
        }
    }
}
