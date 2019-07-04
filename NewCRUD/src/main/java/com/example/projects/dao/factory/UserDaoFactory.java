package com.example.projects.dao.factory;

import com.example.projects.dao.UserDao;
import com.example.projects.dao.factory.hibernate.UserHibernateDaoImpl;
import com.example.projects.dao.factory.jdbc.UserJdbcDaoImpl;
import com.example.projects.dao.property.PropertyReader;

public class UserDaoFactory {
    private static UserDaoFactory ourInstance = new UserDaoFactory();
    private final UserDao dao;

    public static UserDaoFactory getInstance() {
        return ourInstance;
    }

    private UserDaoFactory() {
        dao = createDAO(PropertyReader.getInstance().getProperty());
    }
    private UserDao createDAO(String typeOfDAO) {
        if (typeOfDAO.equalsIgnoreCase("JDBC")) {
            return new UserJdbcDaoImpl();
        }
        if (typeOfDAO.equalsIgnoreCase("hibernate")) {
            return new UserHibernateDaoImpl();
        }
        return null;
    }
    public UserDao getDao(){
        return this.dao;
    }
}

