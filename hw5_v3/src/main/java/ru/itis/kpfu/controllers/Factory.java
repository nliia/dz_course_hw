package ru.itis.kpfu.controllers;

import ru.itis.kpfu.model.dao.UserDao;
import ru.itis.kpfu.model.dao.daoImpl.UserDaoImpl;

/**
 * Created by Liia on 01.11.2016.
 */
public class Factory {

    private static UserDao userDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public UserDao getUserDao(){
        if (userDAO == null){
            userDAO = new UserDaoImpl();
        }
        return userDAO;
    }


}

