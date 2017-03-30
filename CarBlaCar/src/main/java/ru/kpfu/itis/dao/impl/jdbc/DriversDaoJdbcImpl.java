package ru.kpfu.itis.dao.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.dao.DriversDao;
import ru.kpfu.itis.dao.factory.JDBCConnectionFactory;
import ru.kpfu.itis.model.Driver;
import ru.kpfu.itis.service.UsersService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DriversDaoJdbcImpl implements DriversDao {
    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    @Autowired
    UsersService usersService;

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }
    @Override
    public void save(Driver driver) {

    }

    @Override
    public Driver findOne(Long id) {
        return null;
    }

    @Override
    public List<Driver> findAll() {
        return null;
    }

    @Override
    public List<Driver> findTop9ByOrderByRatingDesc() {
        //TODO: реализовать метод
        List<Driver> drivers = new ArrayList<>();
        try {
            con = JDBCConnectionFactory.getInstance().getConnection();
            ptmt = con.prepareStatement("SELECT * FROM drivers ORDER BY rating DESC limit 9");
            rs = ptmt.executeQuery();
            while (rs.next()) {
                Driver driver = new Driver();
                driver.setId(rs.getLong("id"));
                driver.setExperience(rs.getInt("experience"));
                driver.setRating(rs.getInt("rating"));
                driver.setUser(usersService.findById(rs.getLong("user_id")));
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }
}
