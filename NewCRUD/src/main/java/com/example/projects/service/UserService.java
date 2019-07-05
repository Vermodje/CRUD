package com.example.projects.service;

import com.example.projects.dao.UserDao;
import com.example.projects.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void add(User user) throws SQLException;

    List getAllUsers();

    void edit(User user) throws SQLException;

    void delete(Long id);

    User getUserById(Long id);

    User getUserByLogin(String login);

    UserDao getDAO();
}
