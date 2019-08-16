package io.github.aleknik.streetcamloader.controller;

import io.github.aleknik.streetcamloader.service.MessageSenderService;
import io.github.aleknik.streetcamloader.service.StreetCamService;
import model.StreetCamInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    final private StreetCamService streetCamService;
    final private MessageSenderService messageSenderService;

    public TestController(StreetCamService streetCamService, MessageSenderService messageSenderService) {
        this.streetCamService = streetCamService;
        this.messageSenderService = messageSenderService;
    }

    @GetMapping("/test")
    public ResponseEntity findAll() {
        final List<StreetCamInfo> cameras = streetCamService.getCameras(50, 0);

        for (StreetCamInfo camera : cameras) {
            messageSenderService.send(camera);
        }

        return ResponseEntity.ok(cameras);
    }
}
