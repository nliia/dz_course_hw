package ru.kpfu.itis.dao.impl.jdbc;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.dao.UsersDao;
import ru.kpfu.itis.dao.factory.JDBCConnectionFactory;
import ru.kpfu.itis.dao.impl.hibernate.AutosDaoHibernateImpl;
import ru.kpfu.itis.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDaoJdbcImpl implements UsersDao {

    private static final Logger logger = Logger.getLogger(AutosDaoHibernateImpl.class);

    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void save(User user) {
        //TODO: реализовать метод
        try {
            con = JDBCConnectionFactory.getInstance().getConnection();
            ptmt = con.prepareStatement("INSERT INTO users (id, avatar, email, firstname, nickname, password, role, surname) VALUES (?,?,?,?,?,?,?,?)");
            ptmt.setLong(1, user.getId());
            ptmt.setString(2, user.getAvatar());
            ptmt.setString(3, user.getEmail());
            ptmt.setString(4, user.getFirstname());
            ptmt.setString(5, user.getNickname());
            ptmt.setString(6, user.getPassword());
            ptmt.setString(7, user.getRole());
            ptmt.setString(8, user.getSurname());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
        //TODO: реализовать метод
        User user = null;
        try {
            con = JDBCConnectionFactory.getInstance().getConnection();
            ptmt = con.prepareStatement("SELECT * FROM users WHERE LOWER (nickname) LIKE LOWER (?) ");
            ptmt.setString(1, name);
            rs = ptmt.executeQuery();
            user = new User();
            user.setId(rs.getLong("id"));
            user.setPassword(rs.getString("password"));
            user.setNickname(rs.getString("nickname"));
            user.setAvatar(rs.getString("avatar"));
            user.setFirstname(rs.getString("firstname"));
            user.setEmail(rs.getString("email"));
            user.setRole(rs.getString("role"));
            user.setSurname(rs.getString("surname"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByEmailIgnoreCase(String email) {
        return null;
    }
}
