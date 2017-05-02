package ru.kpfu.itis.service.impl;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.dao.ReviewsDao;
import ru.kpfu.itis.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.service.ReviewsService;

import java.util.List;
@Component
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    ReviewsDao reviewsDao;

    public Review addReview(Review review) {
        reviewsDao.save(review);
        return review;
    }

    public void update(Review review) {
        reviewsDao.save(review);
    }

    public List<Review> findAll() {
        return reviewsDao.findAll();
    }

    public Review findById(Long id) {
        return reviewsDao.findOne(id);
    }
}
