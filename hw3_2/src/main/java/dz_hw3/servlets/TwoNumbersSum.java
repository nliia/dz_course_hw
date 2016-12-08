package dz_hw3.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Liia on 17.10.2016.
 */
public class TwoNumbersSum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int first = Integer.parseInt(req.getParameter("first"));
        int second = Integer.parseInt(req.getParameter("second"));

        int result = first + second;

        req.setAttribute("result", result);
        getServletConfig().getServletContext().getRequestDispatcher("/jsp/sum.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
