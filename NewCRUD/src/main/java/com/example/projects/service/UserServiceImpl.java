package com.example.projects.service;

import com.example.projects.dao.UserDao;
import com.example.projects.dao.UserDaoImpl;
import com.example.projects.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private  static UserService service;
    private UserDao dao = new UserDaoImpl();
    private UserServiceImpl(){
    }
    public static synchronized UserService getService(){
        if(service == null){
            service = new UserServiceImpl();
        }
        return service;
    }

    @Override
    public void add(User user) {
        dao.createTable();
        dao.insertUser(user);
    }

    @Override
    public List<User> getAll() {
        return dao.getAllUsers();
    }

    @Override
    public void edit(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delete(int id) {
        dao.deleteUser(id);
    }

    @Override
    public User get(int id) {
        return dao.getUser(id);
    }
}
