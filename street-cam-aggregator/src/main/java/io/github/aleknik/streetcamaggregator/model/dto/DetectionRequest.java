package io.github.aleknik.streetcamaggregator.model.dto;

public class DetectionRequest {

    private String data;

    public DetectionRequest() {
    }

    public DetectionRequest(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
