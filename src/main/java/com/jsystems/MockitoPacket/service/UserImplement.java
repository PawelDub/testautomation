package com.jsystems.MockitoPacket.service;

public interface UserImplement {
    int getId();
    String getName();
    String getSurname();

    boolean isValid(String tekst);

}
