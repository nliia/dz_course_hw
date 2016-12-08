package ru.itis.kpfu.dao;

import ru.itis.kpfu.model.User;

import java.util.List;

public interface CredentialsDao {

    public void add(User user);

    public void update(User user);

    public void delete(Long id);

    public List findAll();

    public User findByPrimaryKey(Long id) ;
    public User findByLogin(String login) ;
}
