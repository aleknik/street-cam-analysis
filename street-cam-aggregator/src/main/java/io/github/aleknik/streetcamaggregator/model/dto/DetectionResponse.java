package io.github.aleknik.streetcamaggregator.model.dto;

public class DetectionResponse {

    private int person;
    private int bicycle;
    private int car;
    private int motorcycle;
    private int airplane;
    private int bus;
    private int train;
    private int truck;
    private int boat;

    public DetectionResponse() {
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

    public int getAirplane() {
        return airplane;
    }

    public void setAirplane(int airplane) {
        this.airplane = airplane;
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

    public int getBoat() {
        return boat;
    }

    public void setBoat(int boat) {
        this.boat = boat;
    }
}
