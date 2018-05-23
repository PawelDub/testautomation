package com.jsystems.models;

public class TestUserGeneric<T> {

    public T id;
    public String name;
    public String surname;

    public TestUserGeneric(T id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public TestUserGeneric() {
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
