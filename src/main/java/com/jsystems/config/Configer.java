package com.jsystems.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configer {

    public static final Config CONFIG = ConfigFactory.load("settings.conf");
    public static final String ENVIRONMENT = CONFIG.getString("environment");
    public static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);
    public static final String baseUri = ENV.getString("base.uri");

    public static final String LOGIN = ENV.getString("login");
    public static final String PASSWORD = ENV.getString("password");
    public static final String DB_URL = ENV.getString("database.url");
    public static final String DB_DRIVER = ENV.getString("database.driver");
    public static final String DB_USERNAME = ENV.getString("database.username");
    public static final String DB_PASSWORD = ENV.getString("database.password");
}
