package com.example.projects.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private final Connection connection;
    private static DBconnection dBconnection;
    private DBconnection(){
        this.connection = getMySqlConnection();
    }
   public static synchronized DBconnection getdBconnection(){
       if(dBconnection == null){
           dBconnection = new DBconnection();
       }
       return dBconnection;
   }

    private static Connection getMySqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_Example?").          //db name
                    append("user=root&").          //login
                    append("password=root");       //password

            return DriverManager.getConnection(url.toString());
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() {
        return connection;
    }

}
