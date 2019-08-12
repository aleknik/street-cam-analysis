package io.github.aleknik.streetcamloader.controller;

import io.github.aleknik.streetcamloader.service.StreetCamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    final private StreetCamService streetCamService;

    public TestController(StreetCamService streetCamService) {
        this.streetCamService = streetCamService;
    }

    @GetMapping("/test")
    ResponseEntity findAll() {
        return ResponseEntity.ok(streetCamService.getCameras());
    }
}
