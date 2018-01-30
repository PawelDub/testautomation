package com.jsystems.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configer {

    public static Config config = ConfigFactory.load("settings.conf");
    public static String environment = config.getString("environment");
    public static Config env = config.getConfig("environments").getConfig(environment);
    public static String baseUri = env.getString("base.uri");
}
