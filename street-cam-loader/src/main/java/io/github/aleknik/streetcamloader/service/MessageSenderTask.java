package io.github.aleknik.streetcamloader.service;

import model.StreetCamInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageSenderTask {

    private static final Logger log = LoggerFactory.getLogger(MessageSenderTask.class);

    @Value("${offset-start}")
    private int offsetStart;

    @Value("${offset-end}")
    private int offsetEnd;

    final private StreetCamService streetCamService;
    final private MessageSenderService messageSenderService;


    public MessageSenderTask(StreetCamService streetCamService, MessageSenderService messageSenderService) {
        this.streetCamService = streetCamService;
        this.messageSenderService = messageSenderService;
    }

    @Scheduled(fixedDelayString = "${rate}")
    public void task() {
        int offset = offsetStart;
        int limit = 50;
        int responseCount = limit;

        while (responseCount >= limit && offset < offsetEnd) {
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
