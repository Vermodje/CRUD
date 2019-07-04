package com.example.projects.hepler;

import com.example.projects.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private final Connection connection;
    private final SessionFactory sessionFactory;
    private static DBHelper dbHelper;
    private DBHelper(){
        connection = setConnection();
        sessionFactory = createSessionFactory(setConfiguration());
    }

    public static  Connection getConnection(){
        if(dbHelper == null){
            dbHelper = new DBHelper();
        }
        return dbHelper.connection;
    }


    public static synchronized SessionFactory getSessionFactory(){
        if(dbHelper == null){
            dbHelper = new DBHelper();
        }
        return dbHelper.sessionFactory;
    }

    private SessionFactory createSessionFactory(Configuration configuration){
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
    private  Connection setConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            String url = "jdbc:mysql://" +
                    //db type
                    "localhost:" +
                    //host name
                    "3306/" +
                    //port
                    "db_Example?" +
                    //db name
                    "user=root&" +
                    //login
                    "password=root";//password
            return DriverManager.getConnection(url);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Configuration setConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db_example");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration;
    }



}
