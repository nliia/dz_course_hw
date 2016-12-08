package ru.itis.kpfu.model.dao;

import ru.itis.kpfu.model.User;

import java.util.List;

/**
 * Created by Liia on 01.11.2016.
 */
public interface UserDao {
    public void add(User user);

    public void update(User user);

    public void delete(Long id);

    public List findAll();

    public User findByPrimaryKey(Long id) ;
    public User findByLogin(String login) ;
}
