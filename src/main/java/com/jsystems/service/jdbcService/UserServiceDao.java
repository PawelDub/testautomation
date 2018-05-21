package com.jsystems.service.jdbcService;

import com.jsystems.mockitoPackage.TestUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServiceDao {

    public TestUser getOne(Long id) {
        String sql = "select * from testUsers where id = " + id;
        TestUser userTest = new TestUser();
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            ResultSet wynik = statement.executeQuery(sql);
            System.out.println(wynik.toString());

            while (wynik.next()) {
                userTest.setId(wynik.getLong(1));
                userTest.setName(wynik.getString(2));
                userTest.setSurname(wynik.getString(3));
            }
            wynik.close();
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userTest;
    }

    public List<TestUser> getAll() {
        List<TestUser> testUsers = new ArrayList<TestUser>();
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            String sql = "select * from testUsers";
            ResultSet wynik = statement.executeQuery(sql);
//            testUsers = ladujDane(wynik);
            while (wynik.next()) {
                TestUser testUser = new TestUser();
                testUser.setId(wynik.getLong(1));
                testUser.setName(wynik.getString(2));
                testUser.setSurname(wynik.getString(3));
                testUsers.add(testUser);
            }
            wynik.close();
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return testUsers;
    }

    public void saveOne(TestUser testUser) {
        String sql = "insert into testUsers (id, name, surname) values (" + testUser.getId() + ", '" + testUser.getName() + "', '" + testUser.getSurname() + "')";
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(TestUser testUser, int id) {
        String sql = "update testUsers set id = " + testUser.getId() + ", name = "
                + testUser.getName() + ", surname = " + testUser.getSurname() + " where id = " + id;
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "delete usermock where id = " + id;
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getOneAdamNumber(int number) {
        return "Adam ma numer " + number;
    }

    public List<TestUser> getAllMock() {
        return Arrays.asList(new TestUser(1l, "Adam", "Kowalski"),
                new TestUser(2l, "Iwona", "Jasielska"),
                new TestUser(3l, "iron", "Pływak"));
    }

    public TestUser getOneTestUser(Long user) {
        return new TestUser(4l, "Irek", "Dran");
    }
}