package com.example.projects.service;

import com.example.projects.dao.UserDao;
import com.example.projects.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List getAllUsers();

    void edit(User user);

    void delete(Long id);

    User getUserById(Long id);

    UserDao getDAO();
}
