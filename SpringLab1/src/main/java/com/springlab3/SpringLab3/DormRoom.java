package com.springlab3.SpringLab3;

public class DormRoom {
    private int number;
    private String building;

    public DormRoom(int number, String building) {
        this.number = number;
        this.building = building;
    }

    public String getLocation() {
        return building + " #" + number;
    }
}