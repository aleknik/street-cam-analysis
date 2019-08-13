package model;

import java.io.Serializable;
import java.util.Date;

public class StreetCamInfo implements Serializable {

    private String id;
    private String name;
    private String imageUrl;
    private String imgBase64;
    private double latitude;
    private double longitude;
    private Date date;

    public StreetCamInfo() {
    }

    public StreetCamInfo(String id, String name, String imageUrl, String imgBase64, double latitude, double longitude, Date date) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.imgBase64 = imgBase64;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
