package com.example.projects.service;

import com.example.projects.dao.UserDao;
import com.example.projects.dao.UserHibernateDaoImpl;
import com.example.projects.dao.UserJdbcDaoImpl;
import com.example.projects.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private  static UserService service;
    // FOR JDBC
    //private UserDao dao = new UserJdbcDaoImpl();
    // FOR Hibernate
    private UserDao dao = new UserHibernateDaoImpl();
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
    public void delete(Long id) {
        dao.deleteUser(id);
    }

    @Override
    public User get(Long id) {
        return dao.getUser(id);
    }
}
