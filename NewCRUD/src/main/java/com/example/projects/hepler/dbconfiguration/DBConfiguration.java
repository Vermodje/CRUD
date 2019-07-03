package com.example.projects.hepler.dbconfiguration;

import com.example.projects.model.User;
import org.hibernate.cfg.Configuration;

public class DBConfiguration {
    private final Configuration configuration;
    private static DBConfiguration dbConfiguration;

    private DBConfiguration() {
        configuration = setConfiguration();
    }

    public static synchronized Configuration getConfiguration() {
        if (dbConfiguration == null) {
            dbConfiguration = new DBConfiguration();
        }
        return dbConfiguration.getHibernateConfiguration();
    }

    private static Configuration setConfiguration() {
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
    private Configuration getHibernateConfiguration(){
        return configuration;
    }
}
