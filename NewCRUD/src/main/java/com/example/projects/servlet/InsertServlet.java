package com.example.projects.servlet;

import com.example.projects.model.User;
import com.example.projects.service.UserService;
import com.example.projects.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/insert")
public class InsertServlet extends HttpServlet {
    private UserService service = UserServiceImpl.getService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        User user = new User(name, password, login);
        service.add(user);
        resp.sendRedirect("/");
    }
}
