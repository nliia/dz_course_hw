package ru.itis.kpfu;

import ru.itis.kpfu.dao.CredentialsDao;
import ru.itis.kpfu.dao.CredentialsDaoImpl;

/**
 * Created by Liia on 01.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        CredentialsDao credentialsDao = new CredentialsDaoImpl();
        System.out.println(credentialsDao.findAll());
    }
}
