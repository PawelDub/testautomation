package com.jsystems.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;

public class DeviceModel implements Serializable{


    public String produce;

    @JsonProperty(value = "screen.size", required = true)
    public String screen_size;

    @Override
    public String toString() {
        return "DeviceModel{" +
                "producec='" + produce + '\'' +
                ", screen_size='" + screen_size + '\'' +
                '}';
    }
}
