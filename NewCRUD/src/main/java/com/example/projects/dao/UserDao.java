package com.example.projects.dao;

import com.example.projects.model.User;

import java.util.List;


public interface UserDao {
    void createTable();
    void insertUser(User user);
    List<User> getAllUsers();
    User getUser(int id);
    void updateUser(User user);
    void deleteUser(int id);
}
