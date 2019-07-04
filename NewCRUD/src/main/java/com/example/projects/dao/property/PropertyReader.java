package com.example.projects.dao.property;

import com.example.projects.dao.factory.UserDaoFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static PropertyReader ourInstance = new PropertyReader();
    private final String property;

    public static PropertyReader getInstance() {
        return ourInstance;
    }

    private PropertyReader() {
        property = readProperties("config.properties");
    }

    private static String readProperties(String path) {
        Properties properties = new Properties();
        try (InputStream in = UserDaoFactory.class.getClassLoader().getResourceAsStream(path)) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("typeOfDAO");
    }
    public String getProperty(){
        return this.property;
    }
}
