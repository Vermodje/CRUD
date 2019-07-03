package com.example.projects.dao;

import com.example.projects.model.User;

import java.util.List;


public interface UserDao {

    void insertUser(User user);

    List getAllUsers();

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
