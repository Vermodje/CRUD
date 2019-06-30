package com.example.projects.service;

import com.example.projects.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getAll();

    void edit(User user);

    void delete(Long id);

    User get(Long id);
}
