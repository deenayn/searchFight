package com.deenayn.search.fight.config;

import com.deenayn.search.fight.Main;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {

    private static ApplicationConfig instance = null;

    private String googleHost;
    private String googleKey;
    private String googleCx;
    private String bingHost;
    private String bingKey;

    public static ApplicationConfig getInstance() {
        if (instance == null) {
            instance = new ApplicationConfig();
        }
        return instance;
    }

    private ApplicationConfig() {
        try (InputStream stream = Main.class.getClassLoader().getResourceAsStream("application.properties")) {

            Properties properties = new Properties();
            properties.load(stream);

            googleHost = properties.getProperty("google.host");
            googleKey = properties.getProperty("google.key");
            googleCx = properties.getProperty("google.cx");
            bingHost = properties.getProperty("bing.host");
            bingKey = properties.getProperty("bing.key");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getGoogleHost() {
        return googleHost;
    }

    public String getGoogleKey() {
        return googleKey;
    }

    public String getGoogleCx() {
        return googleCx;
    }

    public String getBingHost() {
        return bingHost;
    }

    public String getBingKey() {
        return bingKey;
    }
}
