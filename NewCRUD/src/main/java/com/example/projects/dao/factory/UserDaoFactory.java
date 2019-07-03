package com.example.projects.dao.factory;


import com.example.projects.dao.UserDao;
import com.example.projects.dao.factory.hibernate.UserHibernateDaoImpl;
import com.example.projects.dao.factory.jdbc.UserJdbcDaoImpl;
import org.hibernate.Session;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {
    private static UserDaoFactory factory;
    private static Properties properties = new Properties();
    private UserDao dao;

    private UserDaoFactory() {
        dao = createDAO(readProperties("config.properties"));
    }

    public static synchronized UserDao getUserDAO() {
        if (factory == null) {
            factory = new UserDaoFactory();
        }
        return factory.getDao();
    }

    private static String readProperties(String path) {
        try (InputStream in = UserDaoFactory.class.getClassLoader().getResourceAsStream(path)) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("typeOfDAO");
    }

    private static UserDao createDAO(String typeOfDAO) {
        if (typeOfDAO.equalsIgnoreCase("JDBC")) {
            return new UserJdbcDaoImpl();
        }
        if (typeOfDAO.equalsIgnoreCase("hibernate")) {
            return new UserHibernateDaoImpl();
        }
        return null;
    }

    private UserDao getDao() {
        return dao;
    }

}
