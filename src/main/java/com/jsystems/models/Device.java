package com.jsystems.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Device implements Serializable {
    public String type;

    @JsonProperty(value = "device.model", required = true)
    public List<DeviceModel> deviceModel;

    @Override
    public String toString() {
        return "\n\t{" +
                "\n\ttype : '" + type + '\'' +
                ", \n\tdeviceModel : " + deviceModel + "\n\t}";
    }

//    public String toString() {
//        return "\n\t{" +
//                "\n\t\timie : '" + imie + '\'' +
//                ", \n\t\tnazwisko : '" + nazwisko + '\'' +
//                ", \n\t\tdevice :" + device + "\n\t}";
//    }
}
