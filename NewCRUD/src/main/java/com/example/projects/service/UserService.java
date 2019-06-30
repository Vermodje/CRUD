package com.example.projects.service;

import com.example.projects.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAll();
    void edit(User user);
    void delete(int id);
    User get(int id);
}
