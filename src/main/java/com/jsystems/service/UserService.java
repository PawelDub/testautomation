package com.jsystems.service;

import com.jsystems.mockitoPacket.UserMock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {


    public List<UserMock> ladujDane(ResultSet wynik) {
        List<UserMock> userMocks = new ArrayList<UserMock>();
        try {
            while (wynik.next()) {
                UserMock userMock = new UserMock();
                userMock.setId(wynik.getLong(1));
                userMock.setName(wynik.getString(2));
                userMock.setSurname(wynik.getString(3));

                userMocks.add(userMock);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userMocks;
    }

    public UserMock getOne(Long id) {
        UserMock userMock = new UserMock();
        String sql = "select * from usermock where id = " + id;
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            ResultSet wynik = statement.executeQuery(sql);
            System.out.println(wynik.toString());
            userMock = ladujDane(wynik).get(0);
            wynik.close();
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userMock;
    }

    public List<UserMock> getAll() {
        List<UserMock> mockUsers = new ArrayList<UserMock>();
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            String sql = "select * from usermock";
            ResultSet wynik = statement.executeQuery(sql);
            mockUsers = ladujDane(wynik);
            wynik.close();
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mockUsers;
    }

    public void saveOne(UserMock userMock) {
        String sql = "insert into usermock (id, name, surname) values (" + userMock.getId() + ", '" + userMock.getName() + "', '" + userMock.getSurname() + "')";
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void update(UserMock userMock, int id) {
        String sql = "update usermock set id =" + userMock.getId()+ ", name ='"
                + userMock.getName() + "', surname ='" + userMock.getSurname() + " where id =" + id;
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "delete usermock where id =" + id;
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public String getOneAdamNumber(int number){
        return "Adam ma numer " + number;
    }

    public List<UserMock> getAllMock(){
        return Arrays.asList(new UserMock(1l,"Adam", "Kowalski"),
                new UserMock(2l,"Iwona", "Jasielska"),
                new UserMock(3l,"iron", "Pływak"));
    }

    public UserMock getOneMock(Long user){
        return new UserMock(4l,"Irek", "Dran");
    }
}
