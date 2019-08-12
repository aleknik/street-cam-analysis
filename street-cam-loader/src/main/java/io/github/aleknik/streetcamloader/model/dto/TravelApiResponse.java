package io.github.aleknik.streetcamloader.model.dto;

import java.util.List;

public class TravelApiResponse {

    private List<WabCamResponse> webcams;


    public List<WabCamResponse> getWebcams() {
        return webcams;
    }

    public void setWebcams(List<WabCamResponse> webcams) {
        this.webcams = webcams;
    }
}
