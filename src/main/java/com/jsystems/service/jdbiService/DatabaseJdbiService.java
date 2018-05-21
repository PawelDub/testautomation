package com.jsystems.service.jdbiService;

import com.jsystems.config.Configer;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class DatabaseJdbiService {
    private static Jdbi jdbi;
    private static Handle handle;

    static {
        jdbi = Jdbi.create(Configer.DB_URL, Configer.DB_USERNAME, Configer.DB_PASSWORD);
        jdbi.installPlugin(new SqlObjectPlugin());
        handle = jdbi.open();
    }

    public Handle getHandle(){
        return DatabaseJdbiService.handle;
    }
}