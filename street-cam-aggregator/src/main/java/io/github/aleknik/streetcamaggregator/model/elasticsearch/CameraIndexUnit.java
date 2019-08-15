package io.github.aleknik.streetcamaggregator.model.elasticsearch;


import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

import java.util.Date;

@Document(indexName = CameraIndexUnit.INDEX_NAME, type = CameraIndexUnit.TYPE_NAME, shards = 1, replicas = 0)
public class CameraIndexUnit {

    public static final String INDEX_NAME = "street-cams";
    public static final String TYPE_NAME = "street-cam";

    @Id
    private String id;

    @Field(type = FieldType.Date, store = true)
    private Date date;

    @GeoPointField
    private GeoPoint location;

    @Field(type = FieldType.Text, store = true)
    private String name;

    @Field(type = FieldType.Keyword, store = true)
    private String externalId;

    @Field(type = FieldType.Integer, store = true)
    private int person;

    @Field(type = FieldType.Integer, store = true)
    private int bicycle;

    @Field(type = FieldType.Integer, store = true)
    private int car;

    @Field(type = FieldType.Integer, store = true)
    private int motorcycle;

    @Field(type = FieldType.Integer, store = true)
    private int bus;

    @Field(type = FieldType.Integer, store = true)
    private int train;

    @Field(type = FieldType.Integer, store = true)
    private int truck;

    public CameraIndexUnit() {
    }

    public CameraIndexUnit(Date date, double latitude, double longitude,
                           String name, String externalId, int person, int bicycle,
                           int car, int motorcycle, int bus,
                           int train, int truck) {
        this.date = date;
        this.name = name;
        this.externalId = externalId;
        this.person = person;
        this.bicycle = bicycle;
        this.car = car;
        this.motorcycle = motorcycle;
        this.bus = bus;
        this.train = train;
        this.truck = truck;

        this.location = new GeoPoint(latitude, longitude);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public int getBicycle() {
        return bicycle;
    }

    public void setBicycle(int bicycle) {
        this.bicycle = bicycle;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public int getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(int motorcycle) {
        this.motorcycle = motorcycle;
    }


    public int getBus() {
        return bus;
    }

    public void setBus(int bus) {
        this.bus = bus;
    }

    public int getTrain() {
        return train;
    }

    public void setTrain(int train) {
        this.train = train;
    }

    public int getTruck() {
        return truck;
    }

    public void setTruck(int truck) {
        this.truck = truck;
    }

}
