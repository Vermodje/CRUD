package com.example.projects.dao;

import com.example.projects.model.User;

import java.sql.SQLException;
import java.util.List;


public interface UserDao {

    void insertUser(User user) throws SQLException;

    List getAllUsers();

    User getUserById(Long id);

    User getUserByLogin(String login);

    void updateUser(User user) throws SQLException;

    void deleteUser(Long id);
}
