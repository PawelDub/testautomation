package com.jsystems.models;

import java.io.Serializable;

public class MockServerPerson implements Serializable {
    public String name;
    public String surname;
    public Integer age;

    public MockServerPerson(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public MockServerPerson() {
    }

    @Override
    public String toString() {
        return "MockServerPerson{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
