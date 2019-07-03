package com.example.projects.hepler.dbconnection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final Connection connection;
    private static DBConnection dBconnection;

    private DBConnection() {
        connection = setConnection();
    }

    public static synchronized Connection getConnection() {
        if (dBconnection == null) {
            dBconnection = new DBConnection();
        }
        return dBconnection.getMySqlConnection();
    }

    private static Connection setConnection() {
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
    private Connection getMySqlConnection(){
        return connection;
    }


}
