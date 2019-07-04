package com.example.projects.service;

import com.example.projects.dao.UserDao;
import com.example.projects.dao.factory.UserDaoFactory;
import com.example.projects.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = UserDaoFactory.getInstance().getDao();
    private static UserService ourInstance = new UserServiceImpl();
    private UserServiceImpl(){

    }
    public static UserService getInstance(){
        return ourInstance;
    }

    @Override
    public void add(User user) throws SQLException {
        dao.insertUser(user);
    }

    @Override
    public List getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void edit(User user) throws SQLException {
        dao.updateUser(user);
    }

    @Override
    public void delete(Long id) {
        dao.deleteUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return dao.getUserById(id);
    }

    @Override
    public UserDao getDAO() {
        return dao;
    }
}
