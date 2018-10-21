package com.jsystems.models;

import java.io.Serializable;
import java.util.List;

public class User {

    public String imie;
    public String nazwisko;
    public List<Device> device;

    @Override
    public String toString() {
        return "\n\t{" +
                "\n\t\timie : '" + imie + '\'' +
                ", \n\t\tnazwisko : '" + nazwisko + '\'' +
                ", \n\t\tdevice :" + device + "\n\t}";
    }
}