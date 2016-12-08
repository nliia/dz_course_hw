package ru.itis.kpfu.servlets;

import org.apache.commons.codec.digest.DigestUtils;
import ru.itis.kpfu.model.User;
import ru.itis.kpfu.model.dao.daoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Liia on 01.11.2016.
 */
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("password");
        String hash =  DigestUtils.md5Hex(psw + "QxLUF1bgIAdeQX");


        try {
            User newUser = new User();
            newUser.setLogin(username);
            newUser.setPassword(DigestUtils.md5Hex(psw + "QxLUF1bgIAdeQX"));
            UserDaoImpl impl = new UserDaoImpl();
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
