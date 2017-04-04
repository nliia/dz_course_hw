package ru.kpfu.itis.dao.impl.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import ru.kpfu.itis.dao.UsersDao;
import ru.kpfu.itis.dao.factory.HibernateConnectionFactory;
import ru.kpfu.itis.model.User;

import java.util.List;

public class UserDaoHibernateImpl implements UsersDao {

    private static final Logger logger = Logger.getLogger(DriversDaoHibernateImpl.class);

    @Override
    public void save(User user) {
        Session session = null;
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("error saving user by Hibernate", e.getCause());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public User findOne(Long userId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByNickname(String nickname) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByNicknameIgnoreCase(String name) {
        return null;
    }

    @Override
    public User findByEmailIgnoreCase(String email) {
        return null;
    }
}
