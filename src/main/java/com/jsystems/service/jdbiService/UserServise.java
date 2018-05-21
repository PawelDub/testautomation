package com.jsystems.service.jdbiService;

import com.jsystems.mockitoPacket.TestUser;
import com.jsystems.service.jdbcService.UserServiceDao;
import org.jdbi.v3.core.Handle;

public class UserServise {

    private static DatabaseJdbiService databaseJdbiService = new DatabaseJdbiService();
    private static UserDao userDao;
    private static Handle handle = databaseJdbiService.getHandle();

    public static TestUser getTestUser(Long id){
        userDao = handle.attach(UserDao.class);
        return userDao.getTestUserById(id);
    }
}
