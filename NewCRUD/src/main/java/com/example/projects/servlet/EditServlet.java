package com.example.projects.servlet;

import com.example.projects.service.UserService;
import com.example.projects.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    private UserService service = UserServiceImpl.getService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            req.setAttribute("user",  service.get(id));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/edit-user.jsp");
            dispatcher.forward(req, resp);
        } catch (NumberFormatException e){
            e.printStackTrace();
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
