package ru.itis.kpfu.servlets;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import ru.itis.kpfu.dao.CredentialsDaoImpl;
import ru.itis.kpfu.dao.factory.ConnectionFactory;
import ru.itis.kpfu.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Liia on 24.10.2016.
 */
public class ProfileServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("password");
        String hash =  DigestUtils.md5Hex(psw + "QxLUF1bgIAdeQX");


        try {
            User newUser = new User();
            newUser.setLogin(username);
            newUser.setPassword(DigestUtils.md5Hex(psw + "QxLUF1bgIAdeQX"));
            CredentialsDaoImpl impl = new CredentialsDaoImpl();
            impl.update(newUser);
           // HttpSession httpSession = req.getSession();
            req.setAttribute("error", true);
            getServletConfig().getServletContext().getRequestDispatcher("/profile.ftl").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
