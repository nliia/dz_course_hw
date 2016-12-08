package dz_hw3.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Liia on 11.10.2016.
 */
public class FileSearcher extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getParameter("path");
        String namePart = req.getParameter("name");

        File f = new File(path);
        String[] list = f.list();

        List files = new ArrayList();
        for(String file: list){//проверка на совпадение

           if(file.indexOf(namePart) != -1){
                files.add(file);
           }
        }

        req.setAttribute("files", files);
        getServletConfig().getServletContext().getRequestDispatcher("/jsp/file.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
