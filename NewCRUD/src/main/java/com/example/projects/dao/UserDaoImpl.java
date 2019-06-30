package com.example.projects.dao;

import com.example.projects.connection.DBconnection;
import com.example.projects.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private DBconnection dbConnection = DBconnection.getdBconnection();
    private Connection connection = dbConnection.getConnection();
    private User user;
    public UserDaoImpl(){
    }
    @Override
    public void createTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists users (id bigint auto_increment, name varchar(256), password varchar(256), login varchar(256), primary key (id))");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void insertUser(User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement( "insert into users(name, password, login) values (?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> getAllUsers(){
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String login = resultSet.getString("login");
                list.add(new User(id, name, password, login));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public User getUser(Long id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String login = resultSet.getString("login");
                user = new User(id, name, password, login);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public void updateUser(User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users set name = ?, password = ?, login = ? WHERE id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setLong(4, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteUser(Long id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
