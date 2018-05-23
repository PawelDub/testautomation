package com.jsystems.service.jdbiService;

import com.jsystems.service.jdbiService.model.JdbiUser;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface UserDao {

    @SqlQuery("select * from testUser where id = ?")
    @RegisterConstructorMapper(JdbiUser.class)
    JdbiUser getTestUserById(Long id);

    @SqlQuery("select * from testUser")
    @RegisterConstructorMapper(JdbiUser[].class)
    List<JdbiUser> getAllTestUsers();

    @SqlUpdate("insert into testUser (id, name, surname) values (:id, :name, :surname)")
    void insert(long id, String name, String surname);

    @SqlUpdate("update testUser set name = :name where id = ?")
    void updateUser(String name, Long id);

    @SqlUpdate("delete testUser where id = ?")
    void deleteUser(Long id);
}
