package executor;

import connection.DB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Executor {
    private Connection connection;

    public Executor() {
        DB_connection dbConnection = new DB_connection();
        connection = dbConnection.getConnection();
    }

    public void execUpdate(String name, String password, String login) {
        String updates = "insert into users(name, password, login) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updates);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, login);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
