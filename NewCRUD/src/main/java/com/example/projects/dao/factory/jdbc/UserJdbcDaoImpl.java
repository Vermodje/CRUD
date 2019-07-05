package com.example.projects.dao.factory.jdbc;

import com.example.projects.dao.UserDao;
import com.example.projects.hepler.DBHelper;
import com.example.projects.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDaoImpl implements UserDao {
    private User user;
    private Connection connection = DBHelper.getInstance().getConnection();

    private void createTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists users (id bigint auto_increment, name varchar(45), password varchar(45), login varchar(45), role varchar (45), primary key (id), unique index login_unique (login ASC)) DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_general_ci;");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUser(User user) throws SQLException {
        this.createTable();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(name, password, login, role) values (?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.executeUpdate();
            preparedStatement.close();


    }

    @Override
    public List getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String login = resultSet.getString("login");
                String role = resultSet.getString("role");
                list.add(new User(id, name, password, login, role));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User getUserById(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String login = resultSet.getString("login");
                String role = resultSet.getString("role");
                user = new User(id, name, password, login, role);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users WHERE login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                user = new User(id, name, password, login, role);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) throws SQLException {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users set name = ?, password = ?, login = ?, role = ? WHERE id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setLong(5, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
    }

    @Override
    public void deleteUser(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "You are using JDBC";
    }

   /* public static void main(String[] args) {
        UserDao dao = new UserJdbcDaoImpl();
        System.out.println(dao.getUserByLogin("slava"));
    }*/
}
