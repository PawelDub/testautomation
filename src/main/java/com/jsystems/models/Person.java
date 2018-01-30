package com.jsystems.models;
public class Person {
    private long id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        if (age <= 0) {
            throw new IllegalArgumentException("Invalid age:" + age);
        }
    }
}