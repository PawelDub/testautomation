package com.jsystems.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Device implements Serializable {
    public String type;

    @JsonProperty("device.model")
    public List<DeviceModel> deviceModel;

    @Override
    public String toString() {
        return "Device{" +
                "type='" + type + '\'' +
                ", deviceModel=" + deviceModel +
                '}';
    }
}
