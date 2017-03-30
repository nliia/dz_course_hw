package ru.kpfu.itis.dao.impl.jdbc;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.dao.PassengersDao;
import ru.kpfu.itis.model.Passenger;

import java.util.List;

@Component
public class PassengersDaoJdbcImpl implements PassengersDao{
    @Override
    public void save(Passenger passenger) {

    }

    @Override
    public Passenger findOne(Long id) {
        return null;
    }

    @Override
    public List<Passenger> findAll() {
        return null;
    }
}
