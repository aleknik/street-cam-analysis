package io.github.aleknik.streetcamaggregator.service;

import io.github.aleknik.streetcamaggregator.model.dto.DetectionResponse;
import io.github.aleknik.streetcamaggregator.model.elasticsearch.CameraIndexUnit;
import io.github.aleknik.streetcamaggregator.repository.elasticsearch.ESCameraRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CameraIndexerService {

    private final ESCameraRepository esCameraRepository;

    public CameraIndexerService(ESCameraRepository esCameraRepository) {
        this.esCameraRepository = esCameraRepository;
    }

    public void index(DetectionResponse detectionResponse, Date date, double latitude, double longitude, String title, String id) {

        final CameraIndexUnit cameraIndexUnit = new CameraIndexUnit(date, latitude, longitude, title, id,
                detectionResponse.getPerson(),
                detectionResponse.getBicycle(),
                detectionResponse.getCar(),
                detectionResponse.getMotorcycle(),
                detectionResponse.getBus(),
                detectionResponse.getTrain(),
                detectionResponse.getTruck());

        esCameraRepository.index(cameraIndexUnit);
    }
}
