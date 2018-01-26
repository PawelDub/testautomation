package com.jsystems.service;

public class MyObj {
    public String name;
    public String surname;

    @Override
    public String toString() {
        return "MyObj{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }


    public MyObj(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

