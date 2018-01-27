package com.jsystems.service;

import java.io.Serializable;

public class MyObj implements Serializable {

    public String name;
    public String surname;

    @Override
    public String toString() {
        return "MyObj{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public MyObj() {
    }

    public MyObj(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

