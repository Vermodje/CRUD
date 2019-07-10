package com.example.projects.servlet;

import com.example.projects.model.User;
import com.example.projects.service.UserService;
import com.example.projects.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService service = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = service.getUserByLogin(login);
        if (user != null) {
            req.getSession().setAttribute("user", user);
        }
        if ("admin".equals(user.getRole())) {
            resp.sendRedirect("/admin");
        } else {
            resp.sendRedirect("/user");
        }
    }
}
