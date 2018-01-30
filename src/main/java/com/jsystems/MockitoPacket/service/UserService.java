package com.jsystems.MockitoPacket.service;

import com.jsystems.MockitoPacket.UserMock;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public UserMock getOne(int id) {
        UserMock userMock = new UserMock();
        String sql = "select id, name, surname from mockusers where identyfikator =" + id;
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            ResultSet wynik = statement.executeQuery(sql);
            userMock = ladujDane(wynik).get(0);
            wynik.close();
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userMock;
    }

    public List<UserMock> getAll() {
        List<UserMock> mockUsers = new ArrayList<>();
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            String pytanie = "select id, name, surname from mockusers";
            ResultSet wynik = statement.executeQuery(pytanie);
            mockUsers = ladujDane(wynik);
            wynik.close();
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mockUsers;
    }

    public List<UserMock> ladujDane(ResultSet wynik) {
        List<UserMock> userMocks = new ArrayList<UserMock>();
        try {
            while (wynik.next()) {
                UserMock userMock = new UserMock();
                userMock.setId(wynik.getInt("id"));
                userMock.setName(wynik.getString("name"));
                userMock.setSurname(wynik.getString("surname"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userMocks;
    }
}
