package com.jsystems.service;

public class GamePlay {

    public String play(int number){
        if(number == 0) throw new IllegalArgumentException("Number must not be 0");
        if(number % 3 == 0) return "Ok";
        if(number % 5 == 0) return "NOt ok";
        return String.valueOf(number);
    }
}
