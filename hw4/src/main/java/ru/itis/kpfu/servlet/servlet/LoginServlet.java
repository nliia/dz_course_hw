package ru.itis.kpfu.servlet.servlet;
import org.apache.commons.codec.digest.DigestUtils;
import ru.itis.kpfu.servlet.dao.CredentialsDaoImpl;
import ru.itis.kpfu.servlet.dao.factory.ConnectionFactory;
import ru.itis.kpfu.servlet.model.Credentials;
import ru.itis.kpfu.servlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Liia on 11.10.2016.
 */

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher("/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("password");
        ConnectionFactory conFactory = new ConnectionFactory();
        String hash =  DigestUtils.md5Hex(psw + "QxLUF1bgIAdeQX");
        
        boolean isUserExists = false;
        try {

            System.out.println("Драйвер подключен");
            Connection connection= conFactory.getConnection();
            System.out.println("Cоединение установлено");

            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM credentials where password = ? and login = ?");
            preparedStatement.setString(1, hash);
            preparedStatement.setString(2, username);
            ResultSet result2 = preparedStatement.executeQuery();

            if (result2.next()) {
                isUserExists = true;
            }
            if(isUserExists){
                CredentialsDaoImpl user = new CredentialsDaoImpl();
                User newUser;
                newUser = user.findByLogin(username);
                String first = newUser.getFirstName();
                String last = newUser.getLastName();
                req.getSession().setAttribute("session_uname", username);
                req.setAttribute("first", first);
                req.setAttribute("last", last);
                getServletConfig().getServletContext().getRequestDispatcher("/profile.ftl").forward(req, resp);
            } else {
                req.setAttribute("error", true);
                getServletConfig().getServletContext().getRequestDispatcher("/login.ftl").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
