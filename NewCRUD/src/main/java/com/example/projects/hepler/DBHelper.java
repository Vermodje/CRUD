package com.example.projects.hepler;

import com.example.projects.hepler.dbconfiguration.DBConfiguration;
import com.example.projects.hepler.dbconnection.DBConnection;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;

public class DBHelper {
    private final Connection connection;
    private final Session session;
    private static DBHelper dbHelper;
    private DBHelper(){
        connection = DBConnection.getConnection();
        session = createSession(DBConfiguration.getConfiguration());
    }

    public static synchronized Connection getConnection(){
        if(dbHelper == null){
            dbHelper = new DBHelper();
        }
        return dbHelper.getMySqlConnection();
    }
    public static synchronized Session getSession(){
        if(dbHelper == null){
            dbHelper = new DBHelper();
        }
        return dbHelper.getHibernateSession();
    }

    private static Session createSession(Configuration configuration){
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry).openSession();
    }
    private Connection getMySqlConnection(){
        return connection;
    }
    private Session getHibernateSession(){
        return session;
    }

}
