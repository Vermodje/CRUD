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

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    private UserService service = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            service.delete(id);
            resp.sendRedirect("/admin");

        } catch (NumberFormatException e) {
            req.setAttribute("error", "User on this ID is not found");
            req.getRequestDispatcher("/error/error.jsp").forward(req, resp);
        }

    }

}
