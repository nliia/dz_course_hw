package ru.kpfu.itis.dao.impl.jdbc;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.dao.BookingsDao;
import ru.kpfu.itis.model.Booking;

import java.util.List;

@Component
public class BookingsDaoJdbcImpl implements BookingsDao {
    @Override
    public void save(Booking booking) {

    }

    @Override
    public List<Booking> findAll() {
        return null;
    }

    @Override
    public Booking findOne(Long id) {
        return null;
    }
}
