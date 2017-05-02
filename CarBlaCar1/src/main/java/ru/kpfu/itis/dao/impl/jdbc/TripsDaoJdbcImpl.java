package ru.kpfu.itis.dao.impl.jdbc;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.dao.TripsDao;
import ru.kpfu.itis.model.Trip;

import java.util.List;

@Component
public class TripsDaoJdbcImpl implements TripsDao{
    @Override
    public void save(Trip trip) {

    }

    @Override
    public List<Trip> findAll() {
        return null;
    }

    @Override
    public Trip findOne(Long id) {
        return null;
    }

    @Override
    public List<Trip> findTop10ByOrderByDateDesc() {
        return null;
    }

    @Override
    public List<Trip> findAllByOrderByDateDesc() {
        return null;
    }

    @Override
    public List<Trip> findByStatusOrderByDateDesc(String status) {
        return null;
    }

    @Override
    public List<Trip> findByDepartureAndDestinationOrderByDateDesc(String destination, String departure) {
        return null;
    }
}
