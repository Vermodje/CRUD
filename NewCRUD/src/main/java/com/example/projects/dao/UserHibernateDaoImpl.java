package com.example.projects.dao;

import com.example.projects.model.User;
import com.example.projects.util.Util;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;



public class UserHibernateDaoImpl implements UserDao {
    private Session session;

    public UserHibernateDaoImpl() {
        session = Util.getUtil().getSessionFactory().openSession();
    }

    @Override
    public void insertUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    @Override
    public List<User> getAllUsers() {
        Criteria criteria = session.createCriteria(User.class);
        return (List<User>) criteria.list();
    }

    @Override
    public User getUser(Long id) {
        return (User) session.load(User.class, id);
    }

    @Override
    public void updateUser(User user) {
       Transaction transaction = session.beginTransaction();
       //Обновляет пользователя если пользователь с таким id уже существует
       session.merge(user);
       transaction.commit();
    }

    @Override
    public void deleteUser(Long id) {
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        transaction.commit();

    }
}
