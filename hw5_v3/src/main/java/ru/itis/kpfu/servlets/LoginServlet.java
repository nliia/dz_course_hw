package ru.itis.kpfu.servlets;

import com.sun.net.httpserver.HttpServer;
import org.apache.commons.codec.digest.DigestUtils;
import ru.itis.kpfu.model.User;
import ru.itis.kpfu.model.dao.daoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Liia on 01.11.2016.
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
        String hash =  DigestUtils.md5Hex(psw + "QxLUF1bgIAdeQX");

        try {
            UserDaoImpl user = new UserDaoImpl();
            User newUser = user.findByLogin(username);
            if(newUser != null){
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

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
