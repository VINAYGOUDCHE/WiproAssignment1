package com.springlab3.SpringLab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Freshman {
    private String name;

    @Autowired
    @Qualifier("room202")  // 👈 Inject specific bean
    private DormRoom room;

    public Freshman(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public DormRoom getRoom() {
        return room;
    }
}