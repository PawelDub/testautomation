package com.jsystems.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import java.io.Serializable;

public class DeviceModel implements Serializable{


    public String produce;

    @JsonProperty(value = "screen.size", required = true)
    @Nonnull
    public String screen_size;

    @Override
    public String toString() {
        return "DeviceModel{" +
                "producec='" + produce + '\'' +
                ", screen_size='" + screen_size + '\'' +
                '}';
    }
}
