package ru.itis.kpfu.dao;


import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.itis.kpfu.model.User;
import ru.itis.kpfu.dao.factory.ConnectionFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class CredentialsDaoImpl implements CredentialsDao {

    public void add(User user) {
        Session session = null;
        try {
            session = ConnectionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(User user) {
        Session session = null;
        try {
            session = ConnectionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete(Long id) {
        Session session = null;
        try {
            session = ConnectionFactory.getSessionFactory().openSession();
            session.beginTransaction();

            User user = new User();
            user.setId(id);
            session.delete(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List findAll() {
        Session session = null;
        List users = new ArrayList();
        try {
            session = ConnectionFactory.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public User findByPrimaryKey(Long id) {
        Session session = null;
        User user = null;
        try {
            session = ConnectionFactory.getSessionFactory().openSession();
            user = session.get(User.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findByPrimaryKey'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public User findByLogin(String login) {
        Session session = null;
        User user = null;
        try {
            session = ConnectionFactory.getSessionFactory().openSession();
            user = (User) session.createCriteria(User.class)
                    .add(Restrictions.eq("login", login)).uniqueResult();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findByLogin'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();

            }
        }
        return user;
    }
}
