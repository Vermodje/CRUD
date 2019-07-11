package com.example.projects.servlet;

import com.example.projects.model.User;
import com.example.projects.service.UserService;
import com.example.projects.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    private UserService service = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf((req.getParameter("id")));
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        String role = req.getParameter("role");
        try {
            service.edit(new User(id, name, password, login, role));
        } catch (SQLException e) {
            req.setAttribute("error", "User with the same login already exists");
            req.getRequestDispatcher("/error/error.jsp").forward(req, resp);
        }
        resp.sendRedirect("/admin");
    }
}

