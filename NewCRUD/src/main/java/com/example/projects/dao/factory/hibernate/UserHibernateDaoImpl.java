package com.example.projects.dao.factory.hibernate;

import com.example.projects.dao.UserDao;
import com.example.projects.hepler.DBHelper;
import com.example.projects.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;


public class UserHibernateDaoImpl implements UserDao {
    private Session session = DBHelper.getSessionFactory().openSession();

    @Override
    public void insertUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    @Override
    public List getAllUsers() {
        //HQl - запрос адресован не таблице(SQL), а сущности (название сущности должно совпадать с названием класса-модели)
        return session.createQuery("FROM User").list();
    }

    @Override
    public User getUserById(Long id) {
        return (User) session.load(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) {
        return (User) session.load(User.class, login);
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = session.beginTransaction();
        //Обновляет пользователя если пользователь с таким id уже существует(merge - слияние)
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


    @Override
    public String toString() {
        return "You are using Hibernate";
    }
}
