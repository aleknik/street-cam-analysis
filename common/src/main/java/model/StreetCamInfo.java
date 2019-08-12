package model;

import java.io.Serializable;

public class StreetCamInfo implements Serializable {

    private String name;
    private String imageUrl;

    public StreetCamInfo() {
    }

    public StreetCamInfo(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
