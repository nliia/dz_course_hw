package ru.kpfu.itis.dao.impl.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.dao.DriversDao;
import ru.kpfu.itis.dao.factory.HibernateConnectionFactory;
import ru.kpfu.itis.model.Driver;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriversDaoHibernateImpl implements DriversDao {

    private static final Logger logger = Logger.getLogger(DriversDaoHibernateImpl.class);

    @Override
    public void save(Driver driver) {
        Session session = null;
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(driver);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("drivers not saved", e.getCause());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Driver findOne(Long id) {
        return null;
    }

    @Override
    public List<Driver> findAll() {
        Session session = null;
        List drivers = new ArrayList();
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            drivers = session.createCriteria(Driver.class).list();
        } catch (Exception e) {
            logger.error("error finding all by Hibernate", e.getCause());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return drivers;
    }

    @Override
    public List<Driver> findTop9ByOrderByRatingDesc() {
        //TODO: реализовать метод
        Session session = null;
        List drivers = new ArrayList();
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            drivers = session.createCriteria(Driver.class).addOrder(Order.desc("rating"))
                    .setMaxResults(9).list();
        } catch (Exception e) {
            logger.error("drivers not found", e.getCause());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return drivers;
    }

}
