package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.model.Trip;
import ru.kpfu.itis.model.User;

import java.util.Date;
import java.util.List;

public interface TripsRepository extends JpaRepository<Trip, Long> {

    List<Trip> findTop10ByOrderByDateDesc();

    List<Trip> findAllByOrderByDateDesc();

    List<Trip> findByStatusOrderByDateDesc(final String status);

    List<Trip> findByDepartureAndDestinationOrderByDateDesc(String destination, String departure);


}
