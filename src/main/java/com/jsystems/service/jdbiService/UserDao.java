package com.jsystems.service.jdbiService;

import com.jsystems.mockitoPacket.TestUser;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface UserDao {

    @SqlQuery("select * from testUsers where id = ?")
    TestUser getTestUserById(Long id);

    @SqlQuery("select * from testUsers")
    List<TestUser> getAllTestUsers();

    @SqlUpdate("insert into testUsers (id, name, surname) values (:id, :name, :surname)")
    void insert(long id, String name, String surname);

    @SqlUpdate("update testUsers set name = :name where id = ?")
    void updateUser(String name, Long id);

    @SqlQuery("delete testUsers where id = ?")
    void deleteUser(Long id);
}
