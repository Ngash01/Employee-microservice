package com.ngash.microservices.employeeService.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressMapper {

    private int id;
    private String lane1;
    private String lane2;
    private long zip;
    private String state;

    public AddressMapper() {
    }

    public AddressMapper(int id, String lane1, String lane2, long zip, String state) {
        this.id = id;
        this.lane1 = lane1;
        this.lane2 = lane2;
        this.zip = zip;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLane1() {
        return lane1;
    }

    public void setLane1(String lane1) {
        this.lane1 = lane1;
    }

    public String getLane2() {
        return lane2;
    }

    public void setLane2(String lane2) {
        this.lane2 = lane2;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
