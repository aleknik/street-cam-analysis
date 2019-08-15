package io.github.aleknik.streetcamaggregator.service;

import io.github.aleknik.streetcamaggregator.model.dto.DetectionRequest;
import io.github.aleknik.streetcamaggregator.model.dto.DetectionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DetectionService {

    @Value("${detection-api}")
    private String detectionApi;

    private final RestTemplate restTemplate;

    public DetectionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DetectionResponse detect(DetectionRequest detectionRequest) {
        final DetectionResponse response = restTemplate.postForObject(detectionApi + "/detect", detectionRequest, DetectionResponse.class);
        return response;
    }
}
