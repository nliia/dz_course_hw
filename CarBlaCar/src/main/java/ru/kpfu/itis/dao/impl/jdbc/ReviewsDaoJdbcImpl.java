package ru.kpfu.itis.dao.impl.jdbc;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.dao.ReviewsDao;
import ru.kpfu.itis.model.Review;

import java.util.List;

@Component
public class ReviewsDaoJdbcImpl implements ReviewsDao{
    @Override
    public void save(Review review) {

    }

    @Override
    public List<Review> findAll() {
        return null;
    }

    @Override
    public Review findOne(Long id) {
        return null;
    }
}
