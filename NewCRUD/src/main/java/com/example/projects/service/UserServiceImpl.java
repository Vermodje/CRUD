package com.example.projects.service;

import com.example.projects.dao.UserDao;
import com.example.projects.dao.factory.UserDaoFactory;
import com.example.projects.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = UserDaoFactory.getUserDAO();
    private static UserService service;
    public static synchronized UserService getService(){
        if(service == null){
            service = new UserServiceImpl();
        }
        return service;
    }

    @Override
    public void add(User user) {
        dao.insertUser(user);
    }

    @Override
    public List getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void edit(User user) {
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
