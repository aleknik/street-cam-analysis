package io.github.aleknik.streetcamloader.model.dto;

public class WabCamResponse {

    private String id;
    private ImageResponse image;
    private LocationResponse location;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImageResponse getImage() {
        return image;
    }

    public void setImage(ImageResponse image) {
        this.image = image;
    }

    public LocationResponse getLocation() {
        return location;
    }

    public void setLocation(LocationResponse location) {
        this.location = location;
    }
}
